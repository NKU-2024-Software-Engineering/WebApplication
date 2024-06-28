<template lang="">
    <div style="margin-bottom: 5px; margin-top: 5px; margin-left: 5px">
        <el-input
            placeholder="请输入姓名"
            style="width: 200px"
            :suffix-icon="Search"
            v-model="input_name"
            @keyup.enter.native="load" />
        <el-button type="primary" style="margin-left: 10px" @click="load">查询</el-button>
        <el-button type="success" @click="reset">重置</el-button>
    </div>

    <el-table :data="tableData" :header-cell-style="{ background: '#6565BD' }" border>
        <el-table-column prop="用户id" label="用户ID" width="90" />
        <el-table-column prop="用户名" label="用户名" width="90" />
        <el-table-column prop="姓名" label="姓名" width="90" />
        <el-table-column prop="operate" label="操作" width="auto">
            <template #default="scope">
                <el-button type="primary" @click="check(scope.row)">查看</el-button>
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

    <el-dialog v-model="dialogVisible" title="用户简历" width="500">
        <el-form :model="form" label-width="auto" style="max-width: 600px">
            <el-form-item label="姓名" prop="name">
                <el-col :span="11">
                    <el-input v-model="form.name" :disabled="edit" />
                </el-col>
            </el-form-item>
            <el-form-item label="手机号" prop="tele">
                <el-col :span="11">
                    <el-input v-model="form.tele" :disabled="edit" />
                </el-col>
            </el-form-item>
            <el-form-item label="紧急联系人" prop="ec">
                <el-col :span="11">
                    <el-input v-model="form.ec" :disabled="edit" />
                </el-col>
            </el-form-item>
            <el-form-item label="紧急联系人电话" prop="ect">
                <el-col :span="11">
                    <el-input v-model="form.ect" :disabled="edit" />
                </el-col>
            </el-form-item>
            <el-form-item label="意向岗位" prop="dposition">
                <el-col :span="11">
                    <el-input v-model="form.dposition" :disabled="edit" />
                </el-col>
            </el-form-item>
            <el-form-item label="技能特长" prop="ss">
                <el-col :span="18">
                    <el-input type="textarea" v-model="form.ss" :disabled="edit" />
                </el-col>
            </el-form-item>
            <el-form-item label="经历" prop="exp">
                <el-col :span="18">
                    <el-input type="textarea" v-model="form.exp" :disabled="edit" />
                </el-col>
            </el-form-item>
            <el-form-item label="自我评价" prop="se">
                <el-col :span="18">
                    <el-input type="textarea" v-model="form.se" :disabled="edit" />
                </el-col>
            </el-form-item>
        </el-form>
        <template #footer>
            <div class="dialog-footer">
                <el-button @click="save" type="success" v-show="isVisible">保 存</el-button>
                <el-button @click="dialogVisible = false" type="primary">关 闭</el-button>
            </div>
        </template>
    </el-dialog>
</template>

<script lang="ts" setup>
import { Search } from "@element-plus/icons-vue";

let tableData = ref([{}]);
const { proxy } = getCurrentInstance();
const edit = ref(false);
const isVisible = ref(false);
const total = ref(0);
const pageNum = ref(1);
const pageSize = ref(10);
const input_name = ref("");
const dialogVisible = ref(false);
const form = reactive({
    id: null,
    name: "", // 姓名
    tele: "",
    ec: "", //紧急联系人
    ect: "", //紧急联系人电话
    dposition: "", //意向岗位
    se: "", //自我评价
    ss: "", //技能特长
    exp: "", //经历
    uname: "", //用户名
    cid: "", //简历id
});
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
            url: "/cvs/listPageC", //这里由于之前设置了baseURL,所以直接跳过顶级域名
            params: {},
            data: {
                pageSize: pageSize.value,
                pageNum: pageNum.value,
                param: {
                    name: input_name.value,
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
    load();
};
const get = async (row) => {
    try {
        let { data } = await axios({
            method: "post",
            url: "/cvs/search",
            params: {},
            data: {
                id: row.简历id,
            },
        });
        if (data.code == 200) {
            console.log("查看成功");
            form.id = data.data.用户id;
            form.name = data.data.姓名;
            form.dposition = data.data.意向岗位;
            form.ec = data.data.紧急联系人;
            form.ect = data.data.紧急联系人电话;
            form.exp = data.data.经历;
            form.tele = data.data.手机号;
            form.se = data.data.自我评价;
            form.ss = data.data.技能特长;
            form.uname = data.data.用户名;
            form.cid = data.data.简历id;
        } else {
            alert("查看失败");
        }
    } catch (error) {}
};
const modify = async (row) => {
    get(row);
    edit.value = false;
    isVisible.value = true;
    dialogVisible.value = true;
};
const check = async (row) => {
    get(row);
    edit.value = true;
    isVisible.value = false;
    dialogVisible.value = true;
};
const delete_one = async (row) => {
    try {
        let { data } = await axios({
            method: "post",
            url: "/cvs/delete",
            params: {},
            data: {
                简历id: form.cid,
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
const save = async () => {
    if (form.id == 1) {
    }
    try {
        let { data } = await axios({
            method: "post",
            url: "/cvs/saveOrMod",
            params: {},
            data: {
                姓名: form.name,
                手机号: form.tele,
                紧急联系人: form.ec,
                紧急联系人电话: form.ect,
                意向岗位: form.dposition,
                自我评价: form.se,
                技能特长: form.ss,
                经历: form.exp,
                用户id: form.id,
                用户名: form.uname,
                简历id: form.cid,
            },
        });
        if (data.code == 200) {
            dialogVisible.value = false;
            load();
        } else {
            alert("新增或修改失败");
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
