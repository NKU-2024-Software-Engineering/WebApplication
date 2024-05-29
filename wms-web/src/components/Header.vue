<template lang="">
    <div style="display: flex; line-height: 60px">
        <div style="font-size: 20px; line-height: 60px">
            <el-icon @click="toParent" style="cursor: pointer">
                <component :is="icon[props.set_icon]" />
            </el-icon>
        </div>
        <div style="flex: 1; text-align: center; font-size: 34px">
            <span>后台管理系统</span>
        </div>
        <div class="toolbar">
            <span>王大锤</span>
            <el-dropdown style="margin-left: 5px">
                <el-icon>
                    <i-ep-ArrowDown />
                </el-icon>
                <template #dropdown>
                    <el-dropdown-menu>
                        <el-dropdown-item @click="to_user">个人中心</el-dropdown-item>
                        <el-dropdown-item @click="log_out">退出登录</el-dropdown-item>
                    </el-dropdown-menu>
                </template>
            </el-dropdown>
        </div>
    </div>
</template>

<script setup lang="ts">
import { Expand, Fold } from "@element-plus/icons-vue";
const props = defineProps({
    set_icon: {},
});
const icon = [Fold, Expand];
const emit = defineEmits(["to_index"]);
function toParent() {
    emit("to_index");
}
function to_user() {
    console.log("to_user");
}
function log_out() {
    console.log("log_out");
}
</script>

<style>
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
