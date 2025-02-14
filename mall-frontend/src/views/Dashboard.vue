<template>
  <div class="dashboard-container">
    <!-- 顶部导航 -->
    <el-header class="header">
      <div class="logo">
        <h2>Vaultify</h2>
      </div>
      <el-select v-model="network" placeholder="选择网络">
        <el-option label="Ethereum Network" value="eth"/>
        <el-option label="BSC Network" value="bsc"/>
      </el-select>
    </el-header>

    <el-container>
      <!-- 侧边栏 -->
      <el-aside width="250px">
        <el-menu
            v-model="activeMenu"
            class="side-menu"
            background-color="#fff"
            :unique-opened="true"
            @select="handleMenuSelect"
        >
          <!-- 仪表盘 -->
          <el-menu-item index="dashboard">
            <el-icon>
              <Odometer/>
            </el-icon>
            <span>仪表盘</span>
          </el-menu-item>

          <!-- 个人资料管理 -->
          <el-sub-menu index="profile">
            <template #title>
              <el-icon>
                <User/>
              </el-icon>
              <span>个人资料管理</span>
            </template>
            <el-menu-item index="profile-settings">
              <el-icon>
                <Document/>
              </el-icon>
              <span>个人资料设置</span>
            </el-menu-item>
            <el-menu-item index="profile-avatar">
              <el-icon>
                <Picture/>
              </el-icon>
              <span>修改头像</span>
            </el-menu-item>
          </el-sub-menu>

          <!-- 订单管理 -->
          <el-sub-menu index="orders">
            <template #title>
              <el-icon>
                <Shop/>
              </el-icon>
              <span>订单管理</span>
            </template>
            <el-menu-item index="order-list">
              <el-icon>
                <List/>
              </el-icon>
              <span>订单列表</span>
            </el-menu-item>
            <el-menu-item index="order-history">
              <el-icon>
                <Timer/>
              </el-icon>
              <span>交易历史</span>
            </el-menu-item>
          </el-sub-menu>

          <!-- 设置 -->
          <el-menu-item index="settings">
            <el-icon>
              <Setting/>
            </el-icon>
            <span>设置</span>
          </el-menu-item>
        </el-menu>
      </el-aside>

      <!-- 主要内容区 -->
      <el-main>
        <!-- 仪表盘内容 -->
        <Dashboard v-if="activeMenu === 'dashboard'"/>

        <!-- 个人资料设置 -->
        <ProfileSettings v-if="activeMenu === 'profile-settings'"/>

        <!-- 修改头像 -->
        <ProfileAvatar v-if="activeMenu === 'profile-avatar'"/>

        <!-- 订单列表 -->
        <OrderList v-if="activeMenu === 'order-list'"/>

        <!-- 交易历史 -->
        <OrderHistory v-if="activeMenu === 'order-history'"/>

        <!-- 设置 -->
        <Settings v-if="activeMenu === 'settings'"/>
      </el-main>
    </el-container>
  </div>
</template>

<script setup>
import {ref} from 'vue'
import {
  Odometer,
  User,
  Document,
  Picture,
  Shop,
  List,
  Timer,
  Setting
} from '@element-plus/icons-vue'
import DashboardContent from '@/components/DashboardContent.vue'
import ProfileSettings from '@/components/ProfileSettings.vue'
import ProfileAvatar from '@/components/ProfileAvatar.vue'
import OrderList from '@/components/OrderList.vue'
import OrderHistory from '@/components/OrderHistory.vue'
import Settings from '@/components/Settings.vue'

const network = ref('eth')
const activeMenu = ref('dashboard')

const handleMenuSelect = (index) => {
  activeMenu.value = index
}
</script>

<style scoped>
.dashboard-container {
  height: 100vh;
  background: #fff;
}

.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 20px;
  border-bottom: 1px solid #eee;
}

.side-menu {
  height: 100%;
  border-right: 1px solid #eee;
}
</style>