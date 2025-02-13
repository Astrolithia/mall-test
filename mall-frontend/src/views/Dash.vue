<template>
  <el-container class="app-wrapper">
    <!-- 侧边栏 -->
    <el-aside width="240px" class="sidebar">
      <div class="logo-container">
        <el-avatar :size="24" class="logo">S</el-avatar>
        <span class="title">Shadcn Admin</span>
      </div>

      <div class="menu-section">
        <div class="section-title">General</div>
        <el-menu
            class="sidebar-menu"
            :default-active="activeMenu"
            :collapse="false">
          <el-menu-item index="dashboard">
            <el-icon>
              <Monitor/>
            </el-icon>
            <span>Dashboard</span>
          </el-menu-item>
          <el-menu-item index="tasks">
            <el-icon>
              <Document/>
            </el-icon>
            <span>Tasks</span>
          </el-menu-item>
          <el-menu-item index="apps">
            <el-icon>
              <Grid/>
            </el-icon>
            <span>Apps</span>
          </el-menu-item>
          <el-menu-item index="chats">
            <el-icon>
              <Message/>
            </el-icon>
            <span>Chats</span>
            <el-badge value="2" class="menu-badge"/>
          </el-menu-item>
          <el-menu-item index="users">
            <el-icon>
              <User/>
            </el-icon>
            <span>Users</span>
          </el-menu-item>
        </el-menu>
      </div>
    </el-aside>

    <!-- 主内容区 -->
    <el-container class="main-container">
      <el-header height="60px" class="main-header">
        <div class="nav-menu">
          <el-menu mode="horizontal" :ellipsis="false">
            <el-menu-item index="overview">Overview</el-menu-item>
            <el-menu-item index="customers">Customers</el-menu-item>
            <el-menu-item index="products">Products</el-menu-item>
          </el-menu>
          <el-button text>•••</el-button>
        </div>
        <div class="header-actions">
          <el-input
              v-model="searchText"
              placeholder="Search"
              class="search-input"
          />
          <el-button type="primary" plain>Download</el-button>
        </div>
      </el-header>

      <el-main class="main-content">
        <h2 class="page-title">Dashboard</h2>

        <div class="tabs-container">
          <el-tabs>
            <el-tab-pane label="Overview"/>
            <el-tab-pane label="Analytics"/>
            <el-tab-pane label="Reports"/>
          </el-tabs>
        </div>

        <!-- 主要内容区 -->
        <div class="content-grid">
          <!-- 左侧图表 -->
          <div class="chart-section">
            <div class="section-header">
              <h3>Overview</h3>
            </div>
            <div ref="chartRef" class="chart-container"></div>
          </div>

          <!-- 右侧最近销售 -->
          <div class="recent-sales">
            <div class="section-header">
              <h3>Recent Sales</h3>
              <p>You made 265 sales this month.</p>
            </div>
            <div class="sales-list">
              <div v-for="sale in recentSales" :key="sale.email" class="sale-item">
                <el-avatar :size="28">{{ sale.initials }}</el-avatar>
                <div class="sale-info">
                  <div class="name">{{ sale.name }}</div>
                  <div class="email">{{ sale.email }}</div>
                </div>
                <div class="amount">+${{ sale.amount }}</div>
              </div>
            </div>
          </div>
        </div>
      </el-main>
    </el-container>
  </el-container>
</template>

<script setup>
import {ref, onMounted} from 'vue'
import * as echarts from 'echarts'
import {Monitor, Document, Grid, Message, User} from '@element-plus/icons-vue'

const searchText = ref('')
const chartRef = ref(null)

const recentSales = ref([
  {
    name: 'Olivia Martin',
    email: 'olivia.martin@email.com',
    amount: '1,999.00',
    initials: 'OM'
  },
  {
    name: 'Jackson Lee',
    email: 'jackson.lee@email.com',
    amount: '39.00',
    initials: 'JL'
  }
])

const initChart = () => {
  const chart = echarts.init(chartRef.value)
  const option = {
    grid: {
      left: '3%',
      right: '4%',
      bottom: '3%',
      containLabel: true
    },
    xAxis: {
      type: 'category',
      data: ['Jan', 'Apr', 'Jul', 'Oct'],
      axisLine: {
        show: false
      },
      axisTick: {
        show: false
      }
    },
    yAxis: {
      type: 'value',
      splitLine: {
        show: true,
        lineStyle: {
          type: 'dashed'
        }
      },
      axisLine: {
        show: false
      },
      axisTick: {
        show: false
      }
    },
    series: [{
      data: [120, 80, 60, 40],
      type: 'bar',
      barWidth: '40%',
      color: '#1a1a1a'
    }]
  }
  chart.setOption(option)
}

onMounted(() => {
  initChart()
})
</script>

<style scoped>
.app-wrapper {
  height: 200vh;
  background-color: #fafafa;
}

.sidebar {
  background: #fff;
  border-right: 1px solid #eee;
  padding: 16px 0;
}

.logo-container {
  padding: 0 16px 24px;
  display: flex;
  align-items: center;
  gap: 12px;
}

.title {
  font-weight: 500;
}

.section-title {
  padding: 0 16px 8px;
  color: #666;
  font-size: 13px;
}

.sidebar-menu {
  border-right: none;
}

.main-header {
  background: #fff;
  border-bottom: 1px solid #eee;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 24px;
}

.nav-menu {
  display: flex;
  align-items: center;
}

.header-actions {
  display: flex;
  gap: 12px;
}

.search-input {
  width: 200px;
}

.main-content {
  padding: 40px;
  width: 1200px;
}

.page-title {
  margin: 0 0 16px;
  font-size: 24px;
  font-weight: 500;
}

.content-grid {
  display: grid;
  grid-template-columns: 3fr 500px;
  gap: 24px;
  margin-top: 24px;
}

.chart-section, .recent-sales {
  background: #fff;
  border-radius: 8px;
  padding: 20px;
}

.section-header {
  margin-bottom: 20px;
}

.section-header h3 {
  margin: 0 0 4px;
  font-size: 16px;
  font-weight: 500;
}

.section-header p {
  margin: 0;
  color: #666;
  font-size: 14px;
}

.chart-container {
  height: 300px;
}

.sales-list {
  display: flex;
  flex-direction: column;
  gap: 16px;
}

.sale-item {
  display: flex;
  align-items: center;
  gap: 12px;
}

.sale-info {
  flex: 1;
}

.sale-info .name {
  font-size: 14px;
  font-weight: 500;
}

.sale-info .email {
  color: #666;
  font-size: 13px;
}

.amount {
  font-weight: 500;
}

:deep(.el-menu--horizontal) {
  border-bottom: none;
}

:deep(.el-menu-item) {
  height: 40px;
  line-height: 40px;
}
</style>