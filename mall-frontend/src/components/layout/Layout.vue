<template>
  <el-container class="layout-container">
    <Sidebar/>
    <el-container>
      <el-header>
        <TopNav/>
      </el-header>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script setup>
import Sidebar from './Sidebar.vue'
import TopNav from './TopNav.vue'
</script>

<style scoped>
.layout-container {
  height: 100vh;
}

.el-header {
  padding: 0;
  height: 60px;
  border-bottom: 1px solid #e6e6e6;
}

.el-main {
  background-color: #f5f7fa;
  padding: 20px;
}
</style>