<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" label-width="68px">
      <el-form-item label="支付类型" prop="paytype">
        <el-select v-model="queryParams.paytype" placeholder="请选择支付类型" clearable size="small">
          <el-option
            v-for="dict in paytypeOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="进货时间" prop="inporttime">
        <el-date-picker clearable size="small" style="width: 200px"
          v-model="queryParams.inporttime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择进货时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="进货数量" prop="number">
        <el-input
          v-model="queryParams.number"
          placeholder="请输入进货数量"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="进货价格" prop="inportprice">
        <el-input
          v-model="queryParams.inportprice"
          placeholder="请输入进货价格"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:inport:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:inport:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:inport:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:inport:export']"
        >导出</el-button>
      </el-col>
    </el-row>

    <el-table v-loading="loading" :data="inportList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
	   <!--<el-table-column label="供货商" align="center" prop="busProvider.providername" />-->
      <el-table-column label="商品" align="center" prop="busGoods.goodsname" />
	  
      <el-table-column label="支付类型" align="center" prop="paytype" :formatter="payTypeFormat" />
	   <el-table-column label="进货价格" align="center" prop="inportprice" /> 
      <el-table-column label="进货时间" align="center" prop="inporttime" width="180">
             
	  <template slot-scope="scope">
          <span>{{ parseTime(scope.row.inporttime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作员" align="center" prop="operateperson" />
      <el-table-column label="进货数量" align="center" prop="number" />
      <!--<el-table-column label="备注" align="center" prop="remark" />-->
   
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:inport:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:inport:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改采购管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
		
	 <el-form ref="form" :model="form" :rules="rules" label-width="80px">
		
 
        <el-form-item label="商品">
           <el-select v-model="form.goodsid" placeholder="请选择">
                <el-option
                  v-for="dict in goodOptions"
                  :key="dict.id"
                  :label="dict.goodsname"
                  :value="dict.id"
                ></el-option>
              </el-select>
        </el-form-item>
	  <el-form-item label="支付类型">
          <el-select v-model="form.paytype" placeholder="请选择支付类型">
            <el-option
              v-for="dict in paytypeOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="进货时间" prop="inporttime">
          <el-date-picker clearable size="small" style="width: 200px"
            v-model="form.inporttime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择进货时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="操作员" prop="operateperson">
          <el-input v-model="form.operateperson" placeholder="请输入操作员" />
        </el-form-item>
        <el-form-item label="进货数量" prop="number">
          <el-input v-model="form.number" placeholder="请输入进货数量" />
        </el-form-item>
        <el-form-item label="进货价格" prop="inportprice">
          <el-input v-model="form.inportprice" placeholder="请输入进货价格" />
        </el-form-item>
       
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listInport, getInport, delInport, addInport, updateInport, exportInport } from "@/api/system/inport";

export default {
  name: "Inport",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 总条数
      total: 0,
      // 采购管理表格数据
      inportList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 支付类型字典
      paytypeOptions: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        paytype: undefined,
        inporttime: undefined,
        number: undefined,
        inportprice: undefined,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
    this.getDicts("sys_zf_type").then(response => {
      this.paytypeOptions = response.data;
    });
  },
  methods: {
    /** 查询采购管理列表 */
    getList() {
      this.loading = true;
      listInport(this.queryParams).then(response => {
        this.inportList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 支付类型字典翻译
    payTypeFormat(row, column) {
      return this.selectDictLabel(this.paytypeOptions, row.paytype);
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: undefined,
        paytype: undefined,
        inporttime: undefined,
        operateperson: undefined,
        number: undefined,
        remark: undefined,
        inportprice: undefined,
        providerid: undefined,
        goodsid: undefined
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!=1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
     
	  
	   getInport(0).then(response => {
		 this.goodOptions = response.goods;
		
		 this.open = true;
		 this.title = "添加采购管理";
        
      }); 
	  
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getInport(id).then(response => {
        this.form = response.data;
		this.goodOptions = response.goods;
        this.open = true;
        this.title = "修改采购管理";
      });
    },
    /** 提交按钮 */
    submitForm: function() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != undefined) {
            updateInport(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              } else {
                this.msgError(response.msg);
              }
            });
          } else {
            addInport(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              } else {
                this.msgError(response.msg);
              }
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除采购管理编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delInport(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有采购管理数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportInport(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function() {});
    }
  }
};
</script>