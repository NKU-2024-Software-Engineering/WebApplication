<template>
    <div class="loginBody">
        <div class="Dimg">
            <img src="../../../public/loginImg.jpeg" alt="示例" class="img" />
        </div>
        <div class="loginDiv">
            <div class="login-content">
                <h1 class="login-title">速投平台</h1>
                <el-form :model="loginForm" label-width="100px" :rules="rules" ref="form">
                    <el-form-item label="用户名" prop="account">
                        <el-input v-model="loginForm.account" placeholder="输入用户名" clearable />
                    </el-form-item>
                    <el-form-item label="密码" prop="password">
                        <el-input
                            v-model="loginForm.password"
                            type="password"
                            placeholder="输入密码"
                            clearable
                            @keyup.enter.native="confirm" />
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="confirm" :disabled="confirm_disabled" class="button">
                            确 定
                        </el-button>
                        <el-link type="primary" :underline="false" @click="reg"> 没账号？注册用户</el-link>
                    </el-form-item>
                </el-form>
            </div>
        </div>
    </div>
</template>
<script setup>
var confirm_disabled = ref(false);
var loginForm = ref({
    account: "",
    password: "",
});
const loginImgUrl = ref("../../../public/loginImg.jpeg");
const rules = {
    account: { required: true, message: "请输入账号", trigger: "blur" },
    password: { required: true, message: "请输入密码", trigger: "blur" },
};
const { proxy } = getCurrentInstance();
const confirm = async () => {
    console.log("开始校验");
    confirm_disabled = true;
    const loginFormRef = proxy.$refs.form;
    console.log(loginFormRef.account);
    await loginFormRef.validate(async (valid) => {
        console.log(valid);
        if (valid) {
            let { data } = await axios({
                method: "post",
                url: "/user/login", //这里由于之前设置了baseURL,所以直接跳过顶级域名
                data: {
                    account: loginForm.value.account,
                    password: loginForm.value.password,
                },
            });
            if (data.code == 200) {
                sessionStorage.setItem("CurUser", JSON.stringify(data.data));
                const router = proxy.$router;
                router.replace("/main");
            } else {
                confirm_disabled = false;
                alert("校验失败，用户名或密码错误");
                return false;
            }
        } else {
            confirm_disabled = false;
            console.log("校验失败");
            return false;
        }
    });
};
const reg = () => {
    console.log("reg");
    const router = proxy.$router;
    router.replace("/reg");
};
</script>
<script>
import axios from "axios";
</script>

<style scoped>
.loginBody {
    position: absolute;
    width: 100%;
    height: 100%;
    background-color: #b3c0d1;
}
.Dimg {
    overflow: hidden;
    position: absolute;
    width: 70%;
    right: 30%;
    height: 100%;
}
.img {
    height: 100%;
}
.loginDiv {
    position: absolute;
    left: 70%;
    width: 30%;
    height: 100%;
    background: #fff;
}

.login-title {
    margin: 100px 0;
    text-align: center;
}

.login-content {
    width: 350px;
    height: 250px;
    position: absolute;
    top: 25px;
    left: 25px;
}
.button {
    margin-right: 40px;
}
</style>
