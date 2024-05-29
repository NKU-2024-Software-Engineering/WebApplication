<template #title>
    <el-menu
        style="height: 100vh"
        active-text-color="#ffd04b"
        background-color="#545c64"
        text-color="#fff"
        default-active="/Home"
        :collapse="props.isCollapse"
        :collapse-transition="false">
        <el-menu-item index="/Home">
            <el-icon>
                <i-ep-HomeFilled />
            </el-icon>
            <span>首页</span>
        </el-menu-item>
        <el-menu-item index="/Home1">
            <el-icon>
                <i-ep-UserFilled />
            </el-icon>
            <span>求职者</span>
        </el-menu-item>
        <el-menu-item index="/Home2">
            <el-icon>
                <i-ep-Avatar />
            </el-icon>
            <span>公司HR</span>
        </el-menu-item>
    </el-menu>
</template>
<script lang="ts" setup>
const props = defineProps({
    isCollapse: {
        type: Boolean,
    },
});
</script>

<style>
.layout-container-demo .el-menu {
    border-right: none;
}
</style>
