<template lang="">
    <el-scrollbar>
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
                        >{{ scope.row.level === 0 ? "超级管理员" : scope.row.level === 1 ? "管理员" : "用户" }}</el-tag
                    >
                </template>
            </el-table-column>
            <el-table-column prop="isValid" label="是否有效" width="120"> </el-table-column>
            <el-table-column prop="operate" label="操作" width="auto">
                <el-button type="success">编辑</el-button>
                <el-button type="danger">删除</el-button>
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
    </el-scrollbar>
</template>

<script lang="ts" setup>
let tableData = ref([{}]);
const total = ref(0);
const pageNum = ref(1);
const pageSize = ref(10);
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
                    name: "",
                },
            },
        });
        if (data.code == 200) {
            tableData.value = data.data;
            total.value = data.total;
            console.log(data.data);
        } else {
            alert("获取数据失败");
        }
    } catch (error) {}
    console.log(pageSize.value);
};
load();

// axios({
//     method: "post",
//     url: "/user/listP", //这里由于之前设置了baseURL,所以直接跳过顶级域名
//     params: {},
//     data: {
//         name: "",
//     },
// })
//     .then((res) => res.data)
//     .then((res) => {
//         if (res.code == 200) {
//             tableData = res.data;
//             console.log(res.data);
//         } else {
//             alert("获取数据失败");
//         }
//     });
</script>
<script lang="ts">
import axios from "axios";
</script>
<style scope>
.layout-container-demo .el-main {
    padding: 0;
}
</style>
