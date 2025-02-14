<script setup>
import {ref} from 'vue'
import {useRouter} from 'vue-router'
import {ElMessage} from 'element-plus'

const router = useRouter()

const loginForm = ref({
  username: '',
  password: ''
})

const rules = {
  username: [
    {
      required: true,
      message: '请输入用户名',
      trigger: 'blur'
    }
  ],
  password: [
    {
      required: true,
      message: '请输入密码',
      trigger: 'blur'
    }
  ]
}

import {userLoginService} from '@/api/user.js'

const handleSubmit = () => {
  ElMessage.success('登录成功')
}

const goToRegister = () => {
  router.push('/register')
}
const login = async () => {
  // 调用接口，完成登录
  let result = await userLoginService(loginForm.value);
  ElMessage.success(result.msg ? result.msg : '登录成功')
  // 跳转到首页
  router.push('/')
}
</script>

<template>
  <div class="login-container">
    <div class="login-content">
      <div class="login-header">
        <h1 class="welcome-text">Welcome to Sana</h1>
        <p class="subtitle">购物平台后台系统登录界面</p>
      </div>

      <div class="login-form">
        <el-form :model="loginForm" :rules="rules" @submit.prevent="handleSubmit">
          <el-form-item prop="username">
            <el-input
                v-model="loginForm.username"
                placeholder="请输入用户名"
                size="large"
            />
          </el-form-item>
          <el-form-item prop="password">
            <el-input
                v-model="loginForm.password"
                placeholder="请输入密码"
                type="password"
                size="large"
            />
          </el-form-item>
          <el-button
              class="continue-btn"
              size="large"
              type="primary"
              @click="login"
          >
            登录
          </el-button>
        </el-form>

        <p class="register-text">
          还没有账号？
          <el-link type="primary" @click="goToRegister">点击注册</el-link>
        </p>
      </div>
    </div>
  </div>
</template>

<style scoped>
.login-container {
  width: 100vw;
  min-height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
  background-color: #ffffff;
  padding: 20px;
}

.login-content {
  width: 100%;
  max-width: 400px;
}

.login-header {
  text-align: center;
  margin-bottom: 32px;
}

.welcome-text {
  font-size: 32px;
  font-weight: 600;
  color: #1a1a1a;
  margin: 0 0 8px 0;
}

.subtitle {
  font-size: 20px;
  color: #666;
  margin: 0;
}

.continue-btn {
  width: 100%;
  margin-top: 16px;
  height: 44px;
  background-color: #1a1a1a;
  border: none;
}

.continue-btn:hover {
  background-color: #333;
}

.register-text {
  font-size: 14px;
  color: #909399;
  text-align: center;
  margin-top: 20px;
}

:deep(.el-input__wrapper) {
  height: 44px;
}

:deep(.el-button--primary) {
  background-color: #1a1a1a;
}

:deep(.el-link) {
  font-size: 14px;
}
</style>