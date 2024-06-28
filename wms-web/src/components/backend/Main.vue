<template lang="">
    <div style="margin-bottom: 5px; margin-top: 5px; margin-left: 5px">
        <el-input
            placeholder="请输入姓名"
            style="width: 200px"
            :suffix-icon="Search"
            v-model="input_name"
            @keyup.enter.native="load" />
        <el-select v-model="input_level" placeholder="请选择权限等级" style="width: 200px; margin-left: 5px">
            <el-option v-for="item in options" :label="item.label" :value="item.value" />
        </el-select>
        <el-button type="primary" style="margin-left: 10px" @click="load">查询</el-button>
        <el-button type="success" @click="reset">重置</el-button>
        <el-button type="primary" @click="add">新增</el-button>
    </div>

    <el-table :data="tableData" :header-cell-style="{ background: '#6565BD' }" border>
        <el-table-column prop="id" label="ID" width="60" />
        <el-table-column prop="name" label="姓名" width="180" />
        <el-table-column prop="account" label="账号" width="120" />
        <el-table-column prop="password" label="密码" width="120" />
        <el-table-column prop="level" label="权限等级" width="120">
            <template #default="scope">
                <el-tag
                    :type="scope.row.level === 0 ? 'danger' : scope.row.level === 1 ? 'primary' : 'success'"
                    disable-transitions
                    >{{ scope.row.level === 0 ? "超级管理员" : scope.row.level === 1 ? "管理员" : "普通用户" }}</el-tag
                >
            </template>
        </el-table-column>
        <el-table-column prop="isValid" label="是否有效" width="120"> </el-table-column>
        <el-table-column prop="operate" label="操作" width="auto">
            <template #default="scope">
                <el-button type="success" @click="modify(scope.row)">编辑</el-button>

                <el-popconfirm title="您确定要删除该数据吗?" @confirm="delete_one(scope.row)">
                    <template #reference>
                        <el-button type="danger">删除</el-button>
                    </template>
                </el-popconfirm>
            </template>
        </el-table-column>
    </el-table>
    <div class="demo-pagination-block">
        <el-pagination
            v-model:current-page="pageNum"
            v-model:page-size="pageSize"
            :page-sizes="[5, 10, 20, 30]"
            layout="total, sizes, prev, pager, next, jumper"
            :total="total"
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange" />
    </div>

    <el-dialog v-model="dialogVisible" title="添加一个新用户" width="500">
        <el-form :model="form" :rules="rule" label-width="auto" style="max-width: 600px">
            <el-form-item label="名字" prop="name">
                <el-col :span="11">
                    <el-input v-model="form.name" />
                </el-col>
            </el-form-item>
            <el-form-item label="账号" prop="account">
                <el-col :span="11">
                    <el-input v-model="form.account" />
                </el-col>
            </el-form-item>
            <el-form-item label="密码" prop="password">
                <el-col :span="11">
                    <el-input v-model="form.password" />
                </el-col>
            </el-form-item>
            <el-form-item label="权限等级" prop="level">
                <el-radio-group v-model="form.level">
                    <el-radio value="0" disabled>超级管理员</el-radio>
                    <el-radio value="1" :disabled="radio_disabled">管理员</el-radio>
                    <el-radio value="2" :disabled="radio_disabled">普通用户</el-radio>
                </el-radio-group>
            </el-form-item>
        </el-form>
        <template #footer>
            <div class="dialog-footer">
                <el-button
                    @click="
                        dialogVisible = false;
                        resetForm();
                    "
                    >取 消</el-button
                >
                <el-button type="primary" @click="save"> 确 定 </el-button>
            </div>
        </template>
    </el-dialog>
</template>

<script lang="ts" setup>
import { Search } from "@element-plus/icons-vue";

let tableData = ref([{}]);
const { proxy } = getCurrentInstance();
const radio_disabled = ref(false);
const total = ref(0);
const pageNum = ref(1);
const pageSize = ref(10);
const input_name = ref("");
const input_level = ref();
const dialogVisible = ref(false);
const form = reactive({
    id: null,
    name: "",
    account: "",
    password: "",
    level: "",
});
const rule = {
    name: [
        { required: true, message: "请输入名字", trigger: "blur" },
        { min: 3, max: 20, message: "名字长度应在3-20个字符", trigger: "blur" },
    ],
    account: { required: true, message: "请输入账号", trigger: "blur" },
    password: { required: true, message: "请输入密码", trigger: "blur" },
    level: { required: true, message: "需要设置用户权限", trigger: "blur" },
};
const options = [
    {
        value: 0,
        label: "超级管理员",
    },
    {
        value: 1,
        label: "管理员",
    },
    {
        value: 2,
        label: "普通用户",
    },
];
const resetForm = () => {
    form.id = null;
    form.name = null;
    form.account = null;
    form.password = null;
    form.level = null;
};
const handleSizeChange = (val: number) => {
    console.log(`${val} items per page`);
    pageSize.value = val;
    load();
};
const handleCurrentChange = (val: number) => {
    console.log(`current page: ${val}`);
    pageNum.value = val;
    load();
};
const load = async () => {
    try {
        let { data } = await axios({
            method: "post",
            url: "/user/listPageC", //这里由于之前设置了baseURL,所以直接跳过顶级域名
            params: {},
            data: {
                pageSize: pageSize.value,
                pageNum: pageNum.value,
                param: {
                    name: input_name.value,
                    level: input_level.value,
                    // name: "",
                },
            },
        });
        if (data.code == 200) {
            tableData.value = data.data;
            total.value = data.total;
        } else {
            alert("获取数据失败");
        }
    } catch (error) {}
};
load();
const reset = () => {
    input_name.value = "";
    input_level.value = null;
    load();
};
const add = () => {
    dialogVisible.value = true;
};
const save = async () => {
    if (form.id == 1) {
    }
    try {
        let { data } = await axios({
            method: "post",
            url: "/user/saveOrMod", //这里由于之前设置了baseURL,所以直接跳过顶级域名
            params: {},
            data: {
                id: form.id,
                name: form.name,
                account: form.account,
                password: form.password,
                level: form.level,
            },
        });
        if (data.code == 200) {
            dialogVisible.value = false;
            resetForm();
            load();
        } else {
            alert("新增或修改失败");
        }
    } catch (error) {}
};
const modify = async (row) => {
    if (row.id == 1) {
        radio_disabled.value = true;
    }

    form.id = row.id;
    form.account = row.account;
    form.level = row.level + "";
    form.name = row.name;
    dialogVisible.value = true;
};
const delete_one = async (row) => {
    if (row.id == 1) {
        alert("这个用户无法删除");
        return;
    }
    try {
        let { data } = await axios({
            method: "post",
            url: "/user/delete",
            params: {},
            data: {
                id: row.id,
            },
        });
        if (data.code == 200) {
            console.log("删除成功");
            load();
        } else {
            alert("删除失败");
        }
    } catch (error) {}
};
</script>
<script lang="ts">
import axios from "axios";
</script>
<style scope>
.layout-container-demo .el-main {
    padding: 0;
}
</style>
