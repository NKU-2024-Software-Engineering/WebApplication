<template lang="">
    <el-scrollbar>
        <el-table :data="tableData">
            <el-table-column prop="date" label="Date" width="140" />
            <el-table-column prop="name" label="Name" width="120" /> <el-table-column prop="address" label="Address" />
        </el-table>
    </el-scrollbar>
</template>

<script lang="ts" setup>
import { ref } from "vue";
const item = {
    date: "2016-05-02",
    name: "小红",
    address: "二仙桥走南门大道 拐弯后那个小巷子",
};
const tableData = ref(Array.from({ length: 10 }).fill(item));
axios({
    method: "get",
    url: "/list", //这里由于之前设置了baseURL,所以直接跳过顶级域名
    params: {},
}).then((res) => {
    console.log(res.data);
});
</script>
<script lang="ts">
import axios from "axios";
</script>
<style scope>
.layout-container-demo .el-main {
    padding: 0;
}
</style>
