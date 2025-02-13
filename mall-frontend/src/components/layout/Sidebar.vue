<template>
  <el-aside width="250px">
    <div class="logo">
      <img src="https://kokonutui.com/logo.svg" alt="Logo"/>
      <span>KokonutUI</span>
    </div>
    <el-menu
        default-active="1"
        class="el-menu-vertical"
        :collapse="isCollapse"
        @select="handleSelect"
    >
      <el-sub-menu index="1">
        <template #title>
          <el-icon>
            <HomeFilled/>
          </el-icon>
          <span>Overview</span>
        </template>
        <el-menu-item index="1-1">Dashboard</el-menu-item>
        <el-menu-item index="1-2">Analytics</el-menu-item>
      </el-sub-menu>
      <el-sub-menu index="2">
        <template #title>
          <el-icon>
            <Wallet/>
          </el-icon>
          <span>Finance</span>
        </template>
        <el-menu-item index="2-1">Transactions</el-menu-item>
        <el-menu-item index="2-2">Invoices</el-menu-item>
      </el-sub-menu>
      <el-sub-menu index="3">
        <template #title>
          <el-icon>
            <User/>
          </el-icon>
          <span>Team</span>
        </template>
        <el-menu-item index="3-1">Members</el-menu-item>
        <el-menu-item index="3-2">Permissions</el-menu-item>
      </el-sub-menu>
    </el-menu>
  </el-aside>
</template>

<script setup>
import {ref} from 'vue'
import {HomeFilled, Wallet, User} from '@element-plus/icons-vue'

const isCollapse = ref(false)

const handleSelect = (key, keyPath) => {
  console.log(key, keyPath)
}
</script>

<style scoped>
.el-aside {
  background-color: #304156;
  color: #fff;
}

.logo {
  height: 60px;
  display: flex;
  align-items: center;
  padding-left: 20px;
  font-size: 20px;
  font-weight: bold;
}

.logo img {
  width: 30px;
  margin-right: 10px;
}

.el-menu {
  border-right: none;
}

.el-menu-vertical:not(.el-menu--collapse) {
  width: 250px;
  min-height: 400px;
}
</style>