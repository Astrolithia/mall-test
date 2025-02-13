<template>
  <div class="top-nav">
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/' }">KokonutUI</el-breadcrumb-item>
      <el-breadcrumb-item>Dashboard</el-breadcrumb-item>
    </el-breadcrumb>
    <div class="right-menu">
      <el-button icon="Bell" circle></el-button>
      <el-switch
          v-model="isDark"
          active-icon="Moon"
          inactive-icon="Sunny"
          @change="toggleTheme"
      ></el-switch>
      <el-dropdown>
        <el-avatar :size="32"
                   src="https://ferf1mheo22r9ira.public.blob.vercel-storage.com/avatar-01-n0x8HFv8EUetf9z6ht0wScJKoTHqf8.png"></el-avatar>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item>Profile</el-dropdown-item>
            <el-dropdown-item>Settings</el-dropdown-item>
            <el-dropdown-item>Logout</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>

<script setup>
import {ref} from 'vue'
import {Bell, Moon, Sunny} from '@element-plus/icons-vue'

const isDark = ref(false)

const toggleTheme = (value) => {
  // Implement theme toggling logic here
  console.log('Theme toggled:', value)
}
</script>

<style scoped>
.top-nav {
  display: flex;
  justify-content: space-between;
  align-items: center;
  height: 100%;
  padding: 0 20px;
}

.right-menu {
  display: flex;
  align-items: center;
  gap: 15px;
}
</style>