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
            <span>{{ data.name }}</span>
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
    <div style="text-align: left">
        <el-dialog v-model="dialogVisible" title="提示" width="200">
            <span> 您确定要退出登录吗？ </span>
            <template #footer>
                <div class="dialog-footer">
                    <el-button @click="dialogVisible = false">取消</el-button>
                    <el-button type="primary" @click="confirm"> 确定 </el-button>
                </div>
            </template>
        </el-dialog>
    </div>
</template>

<script setup lang="ts">
import { Expand, Fold } from "@element-plus/icons-vue";
const data = ref(JSON.parse(sessionStorage.getItem("CurUser")));
const dialogVisible = ref(false);
const props = defineProps({
    set_icon: {},
});
const icon = [Fold, Expand];
const emit = defineEmits(["to_index"]);
const { proxy } = getCurrentInstance();
const toParent = () => {
    emit("to_index");
};
const to_user = () => {
    console.log("to_user");
};
const log_out = () => {
    console.log("log_out");
    dialogVisible.value = true;

    // const confirmLogout = confirm("确定要退出登录吗？");

    // // 如果用户点击了确认按钮，则执行退出登录操作
    // if (confirmLogout) {
    //     // 执行退出登录操作，比如清除用户登录状态等
    //     proxy.$router.push("/");
    //     sessionStorage.clear();
    // }
};
const confirm = () => {
    dialogVisible.value = false;
    console.log(proxy.$router);
    sessionStorage.clear();
    proxy.$router.replace("/backend");
};
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
