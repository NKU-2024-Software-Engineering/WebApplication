<script setup></script>
<template>
    <el-container class="layout-container-demo" style="height: 100%">
        <el-aside :width="aside_width">
            <Aside :isCollapse="to_aside"></Aside>
        </el-aside>

        <el-container>
            <el-header style="text-align: right; font-size: 12px">
                <Header @to_index="from_header" :set_icon="local_icon"></Header>
            </el-header>
            <el-main>
                <Main></Main>
            </el-main>
        </el-container>
    </el-container>
</template>
<script lang="ts" setup>
const to_aside = ref(false);
const local_icon = ref(0);
const aside_width = ref("200px");
function from_header() {
    to_aside.value = !to_aside.value;
    if (to_aside.value) {
        aside_width.value = "64px";
        local_icon.value = 1;
    } else {
        aside_width.value = "200px";
        local_icon.value = 0;
    }
}
</script>
<script lang="ts"></script>

<style scoped>
.layout-container-demo .el-main {
    padding: 0;
}

.layout-container-demo .el-aside {
    color: var(--el-text-color-primary);
    /* background: var(--el-color-primary-light-8); */
    background-color: "#545c64";
    height: auto;
    display: flex;
    flex-direction: column;
}
</style>
