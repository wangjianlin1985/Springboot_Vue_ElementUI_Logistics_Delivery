<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" label-width="68px">
      <el-form-item label="商品" prop="goodsid">
        <el-select v-model="queryParams.goodsid" placeholder="请选择商品" clearable size="small">
          <el-option
                  v-for="dict in goodOptions"
                  :key="dict.id"
                  :label="dict.goodsname"
                  :value="dict.id"
                ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="到货时间" prop="shippingTime">
        <el-date-picker clearable size="small" style="width: 200px"
          v-model="queryParams.shippingTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择到货时间">
        </el-date-picker>
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
          v-hasPermi="['system:shippingdoc:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:shippingdoc:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:shippingdoc:remove']"
        >删除</el-button>
      </el-col>
     
    </el-row>

    <el-table v-loading="loading" :data="shippingdocList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="商品" align="center" prop="goodsid" :formatter="goodsidFormat" />
      <el-table-column label="到货时间" align="center" prop="shippingTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.shippingTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="仓管员" align="center" prop="cgy" />
      <el-table-column label="操作员" align="center" prop="operator" />
      <el-table-column label="运送人员" align="center" prop="shipPerson" />
      <el-table-column label="仓库" align="center" prop="warehouse" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:shippingdoc:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:shippingdoc:remove']"
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

    <!-- 添加或修改客户单据对话框 -->
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
		
        <el-form-item label="到货时间" prop="shippingTime">
          <el-date-picker clearable size="small" style="width: 200px"
            v-model="form.shippingTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择到货时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="仓管员" prop="cgy">
          <el-input v-model="form.cgy" placeholder="请输入仓管员" />
        </el-form-item>
        <el-form-item label="操作员" prop="operator">
          <el-input v-model="form.operator" placeholder="请输入操作员" />
        </el-form-item>
        <el-form-item label="运送人员" prop="shipPerson">
          <el-input v-model="form.shipPerson" placeholder="请输入运送人员" />
        </el-form-item>
        <el-form-item label="仓库" prop="warehouse">
          <el-input v-model="form.warehouse" placeholder="请输入仓库" />
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
import { listShippingdoc, getShippingdoc, delShippingdoc, addShippingdoc, updateShippingdoc, exportShippingdoc } from "@/api/system/shippingdoc";

export default {
  name: "Shippingdoc",
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
      // 客户单据表格数据
      shippingdocList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        goodsid: undefined,
        shippingTime: undefined,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      },
      goodOptions: []
    };
  },
  created() { 
    getShippingdoc(0).then(response => {
		    this.goodOptions = response.goods; 
        this.getList(); 
      });  
  },
  methods: {
    /** 查询客户单据列表 */
    getList() {
      this.loading = true;
      listShippingdoc(this.queryParams).then(response => {
        this.shippingdocList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
     // 商品id字典翻译
    goodsidFormat(row, column) {
      for(var i=0;i<this.goodOptions.length;i++) { 
        if(row.goodsid == this.goodOptions[i].id) { 
          return this.goodOptions[i].goodsname;
        } 
      }
       
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
        goodsid: undefined,
        shippingTime: undefined,
        cgy: undefined,
        operator: undefined,
        shipPerson: undefined,
        warehouse: undefined
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
      this.title = "添加客户单据";
	  
	   getShippingdoc(0).then(response => {
		    this.goodOptions = response.goods;
		
		    this.open = true;
		   this.title = "添加客户单据";
        
      }); 
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getShippingdoc(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改客户单据";
      });
    },
    /** 提交按钮 */
    submitForm: function() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != undefined) {
            updateShippingdoc(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              } else {
                this.msgError(response.msg);
              }
            });
          } else {
            addShippingdoc(this.form).then(response => {
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
      this.$confirm('是否确认删除客户单据编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delShippingdoc(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有客户单据数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportShippingdoc(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function() {});
    }
  }
};
</script>