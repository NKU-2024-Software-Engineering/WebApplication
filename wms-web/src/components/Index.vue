<script setup></script>
<template>
    <el-container class="layout-container-demo" style="height: 100%">
        <el-aside width="200px" style="height: 100%">
            <el-scrollbar style="height: 100%">
                <Aside></Aside>
            </el-scrollbar>
        </el-aside>

        <el-container>
            <el-header style="text-align: right; font-size: 12px">
                <Header></Header>
            </el-header>
            <el-main>
                <Main></Main>
            </el-main>
        </el-container>
    </el-container>
</template>

<script lang="ts" setup></script>

<style scoped>
.layout-container-demo .el-main {
    padding: 0;
}
</style>
