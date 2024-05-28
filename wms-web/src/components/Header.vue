<template lang="">
    <div class="toolbar">
        <el-dropdown>
            <el-icon style="margin-right: 8px; margin-top: 1px">
                <setting />
            </el-icon>
            <template #dropdown>
                <el-dropdown-menu>
                    <el-dropdown-item>View</el-dropdown-item>
                    <el-dropdown-item>Add</el-dropdown-item>
                    <el-dropdown-item>Delete</el-dropdown-item>
                </el-dropdown-menu>
            </template>
        </el-dropdown>
        <span>Tom</span>
    </div>
</template>
<script lang="ts" setup>
import { Setting } from "@element-plus/icons-vue";
</script>
<style scope>
.layout-container-demo .el-header {
    position: relative;
    background-color: var(--el-color-primary-light-7);
    color: var(--el-text-color-primary);
}

.layout-container-demo .toolbar {
    display: inline-flex;
    align-items: center;
    justify-content: center;
    height: 100%;
    right: 20px;
}
</style>
