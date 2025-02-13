<script setup>
import {ref} from 'vue'
import {ElMessage} from 'element-plus'

const loginForm = ref({
  username: '',
  password: '',
  repassword: '',
  email: '',
  phone: ''
})

// 校验密码的函数
const checkRePassword = (rule, value, callback) => {
  if (value === '') {
    callback(new Error('请再次输入确认密码'))
  } else if (value !== loginForm.value.password) {
    callback(new Error("请确保两次输入的密码一样"))
  } else {
    callback()
  }
}

// 定义表单校验规则
const rules = {
  username: [
    {
      required: true,
      message: '请输入用户名',
      trigger: 'blur'
    },
    {
      min: 5,
      max: 16,
      message: '长度为5~16位非空字符',
      trigger: 'blur'
    },
  ],
  password: [
    {
      required: true,
      message: '请输入密码',
      trigger: 'blur'
    },
    {
      min: 8,
      max: 16,
      message: '长度为8~16位非空字符',
      trigger: 'blur'
    },
  ],
  repassword: [
    {
      validator: checkRePassword,
      trigger: 'blur'
    }
  ],
  email: [
    {
      required: true,
      message: '请输入邮箱',
      trigger: 'blur'
    }

  ],
  phone: [
    {
      required: true,
      message: '请输入电话',
      trigger: 'blur'
    }
  ]
}

// 添加表单提交处理方法
const handleSubmit = () => {
  ElMessage.success('表单提交成功')
}

// 调用后台接口，完成注册
import {userRegisterService} from '@/api/user.js'

const register = async () => {
  let result = await userRegisterService(loginForm.value);
  if (result.code === 0) {
    alert(result.msg ? result.msg : '注册成功');
  } else {
    alert('注册失败');
  }
}
</script>

<template>
  <div class="login-container">
    <div class="login-content">
      <div class="login-header">
        <h1 class="welcome-text">Welcome to Sana</h1>
        <p class="subtitle">购物平台后台系统注册界面</p>
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
          <el-form-item prop="repassword">
            <el-input
                v-model="loginForm.repassword"
                placeholder="请再次输入密码"
                type="password"
                size="large"
            />
          </el-form-item>
          <el-form-item prop="email">
            <el-input
                v-model="loginForm.email"
                placeholder="请输入邮箱"
                size="large"
            />
          </el-form-item>
          <el-form-item prop="phone">
            <el-input
                v-model="loginForm.phone"
                placeholder="请输入手机"
                size="large"
            />
          </el-form-item>
          <el-button
              class="continue-btn"
              size="large"
              type="primary"
              @click="register"
          >
            注册
          </el-button>
        </el-form>

        <p class="terms-text">
          By signing up, you agree to the
          <el-link href="#" type="primary">Terms of Use</el-link>
          ,
          <el-link href="#" type="primary">Privacy Notice</el-link>
          ,
          and
          <el-link href="#" type="primary">Cookie Notice</el-link>
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

.login-tip {
  text-align: center;
  margin-bottom: 20px;
  color: #666;
}

.google-btn {
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 8px;
  height: 44px;
  border: 1px solid #dcdfe6;
  margin-bottom: 20px;
}

.google-icon {
  width: 18px;
  height: 18px;
}

.divider {
  position: relative;
  text-align: center;
  margin: 20px 0;
}

.divider::before,
.divider::after {
  content: '';
  position: absolute;
  top: 50%;
  width: 45%;
  height: 1px;
  background-color: #dcdfe6;
}

.divider::before {
  left: 0;
}

.divider::after {
  right: 0;
}

.divider-text {
  background-color: #fff;
  padding: 0 10px;
  color: #909399;
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

.terms-text {
  font-size: 12px;
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
  font-size: 12px;
}
</style>