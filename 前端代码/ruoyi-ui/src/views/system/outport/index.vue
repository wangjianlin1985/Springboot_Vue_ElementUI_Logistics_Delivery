<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" label-width="68px">
      <el-form-item label="供应商" prop="providerid">
        <el-select v-model="queryParams.providerid" placeholder="请选择供应商" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="退货时间" prop="outputtime">
        <el-date-picker clearable size="small" style="width: 200px"
          v-model="queryParams.outputtime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择退货时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="商品" prop="goodsid">
        <el-select v-model="queryParams.goodsid" placeholder="请选择商品" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
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
          v-hasPermi="['system:outport:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:outport:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:outport:remove']"
        >删除</el-button>
      </el-col>
    
    </el-row>

    <el-table v-loading="loading" :data="outportList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
	<el-table-column label="供货商" align="center" prop="busProvider.providername" />
      <el-table-column label="商品" align="center" prop="busGoods.goodsname" />
      <el-table-column label="支付类型" align="center" prop="paytype" :formatter="payTypeFormat" />
      <el-table-column label="出库时间" align="center" prop="outputtime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.outputtime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作员" align="center" prop="operateperson" />
      <el-table-column label="价格" align="center" prop="outportprice" />
      <el-table-column label="数量" align="center" prop="number" />
 
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:outport:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:outport:remove']"
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

    <!-- 添加或修改出库管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="供应商">
          <el-select v-model="form.providerid" placeholder="请选择供应商">
             <el-option
                  v-for="dict in postOptions"
                  :key="dict.id"
                  :label="dict.providername"
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
        <el-form-item label="退货时间" prop="outputtime">
          <el-date-picker clearable size="small" style="width: 200px"
            v-model="form.outputtime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择退货时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="操作员" prop="operateperson">
          <el-input v-model="form.operateperson" placeholder="请输入操作员" />
        </el-form-item>
        <el-form-item label="退货价格" prop="outportprice">
          <el-input v-model="form.outportprice" placeholder="请输入退货价格" />
        </el-form-item>
        <el-form-item label="数量" prop="number">
          <el-input v-model="form.number" placeholder="请输入数量" />
        </el-form-item>
        <el-form-item label="商品">
          <el-select v-model="form.goodsid" placeholder="请选择商品">
             <el-option
                  v-for="dict in goodOptions"
                  :key="dict.id"
                  :label="dict.goodsname"
                  :value="dict.id"
                ></el-option>
          </el-select>
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
import { listOutport, getOutport, delOutport, addOutport, updateOutport, exportOutport } from "@/api/system/outport";

export default {
  name: "Outport",
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
      // 出库管理表格数据
      outportList: [],
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
        providerid: undefined,
        outputtime: undefined,
        goodsid: undefined
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      },
      postOptions: [],
      goodOptions: []
    };
  },
  created() {
    this.getList();
    this.getDicts("sys_zf_type").then(response => {
      this.paytypeOptions = response.data;
    });
  },
  methods: {
    /** 查询出库管理列表 */
    getList() {
      this.loading = true;
      listOutport(this.queryParams).then(response => {
        this.outportList = response.rows;
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
        providerid: undefined,
        paytype: undefined,
        outputtime: undefined,
        operateperson: undefined,
        outportprice: undefined,
        number: undefined,
        remark: undefined,
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
      //this.open = true;
      //this.title = "添加出库管理";
      getOutport(0).then(response => {
        this.postOptions = response.providers;
        this.goodOptions = response.goods; 
        this.open = true;
        this.title = "添加出库管理";
      });

    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getOutport(id).then(response => {
        this.form = response.data;
        this.postOptions = response.providers;
        this.goodOptions = response.goods; 
        this.open = true;
        this.title = "修改出库管理";
      });
    },
    /** 提交按钮 */
    submitForm: function() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != undefined) {
            updateOutport(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              } else {
                this.msgError(response.msg);
              }
            });
          } else {
            addOutport(this.form).then(response => {
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
      this.$confirm('是否确认删除出库管理编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delOutport(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有出库管理数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportOutport(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function() {});
    }
  }
};
</script>