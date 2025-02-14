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
      <!-- 修改后的侧边栏 -->
      <el-aside width="250px">
        <el-menu
            :default-active="activeMenu"
            class="side-menu"
            background-color="#fff"
            :unique-opened="true"
        >
          <!-- 仪表盘 -->
          <el-menu-item index="1">
            <el-icon>
              <Odometer/>
            </el-icon>
            <span>仪表盘</span>
          </el-menu-item>

          <!-- 个人资料管理 -->
          <el-sub-menu index="2">
            <template #title>
              <el-icon>
                <User/>
              </el-icon>
              <span>个人资料管理</span>
            </template>
            <el-menu-item index="2-1">
              <el-icon>
                <Document/>
              </el-icon>
              <span>个人资料设置</span>
            </el-menu-item>
            <el-menu-item index="2-2">
              <el-icon>
                <Picture/>
              </el-icon>
              <span>修改头像</span>
            </el-menu-item>
          </el-sub-menu>

          <!-- 订单管理 -->
          <el-sub-menu index="3">
            <template #title>
              <el-icon>
                <Shop/>
              </el-icon>
              <span>订单管理</span>
            </template>
            <el-menu-item index="3-1">
              <el-icon>
                <List/>
              </el-icon>
              <span>订单列表</span>
            </el-menu-item>
            <el-menu-item index="3-2">
              <el-icon>
                <Timer/>
              </el-icon>
              <span>交易历史</span>
            </el-menu-item>
          </el-sub-menu>

          <!-- 设置 -->
          <el-menu-item index="4">
            <el-icon>
              <Setting/>
            </el-icon>
            <span>设置</span>
          </el-menu-item>
        </el-menu>
      </el-aside>

      <!-- 主要内容区 -->
      <el-main>
        <div class="overview-header">
          <h2>Overview</h2>
          <span>Aug 13, 2023 - Aug 18, 2023</span>
        </div>

        <!-- 卡片统计区 -->
        <el-row :gutter="20" class="stat-cards">
          <el-col :span="8">
            <el-card>
              <h3>Your Balance</h3>
              <div class="amount">$74,892</div>
              <div class="change negative">
                +$1,340 -2.1%
              </div>
            </el-card>
          </el-col>
          <el-col :span="8">
            <el-card>
              <h3>Your Deposits</h3>
              <div class="amount">$54,892</div>
              <div class="change positive">
                +$1,340 +13.2%
              </div>
            </el-card>
          </el-col>
          <el-col :span="8">
            <el-card>
              <h3>Accrued Yield</h3>
              <div class="amount">$20,892</div>
              <div class="change positive">
                +$1,340 +1.2%
              </div>
            </el-card>
          </el-col>
        </el-row>

        <!-- 图表区域 -->
        <el-card class="chart-card">
          <div class="chart-header">
            <h3>General Statistics</h3>
            <el-radio-group v-model="timeRange">
              <el-radio-button label="today">Today</el-radio-button>
              <el-radio-button label="week">Last week</el-radio-button>
              <el-radio-button label="month">Last month</el-radio-button>
              <el-radio-button label="6month">Last 6 month</el-radio-button>
              <el-radio-button label="year">Year</el-radio-button>
            </el-radio-group>
          </div>
          <div ref="chartRef" style="height: 300px"></div>
        </el-card>

        <!-- 资产列表 -->
        <el-table :data="vaultData" style="margin-top: 20px">
          <el-table-column label="Vault" width="200">
            <template #default="scope">
              <div class="vault-info">
                <el-avatar :size="30" :src="scope.row.icon"/>
                <div>
                  <div>{{ scope.row.name }}</div>
                  <div class="secondary-text">${{ scope.row.price }}</div>
                </div>
              </div>
            </template>
          </el-table-column>
          <el-table-column label="Daily" width="150">
            <template #default="scope">
              <span :class="scope.row.daily > 0 ? 'positive' : 'negative'">
                +${{ scope.row.daily }}
              </span>
            </template>
          </el-table-column>
          <el-table-column prop="balance" label="Balance" width="150"/>
          <el-table-column prop="apy" label="APY" width="120"/>
          <el-table-column prop="state" label="State" width="120">
            <template #default="scope">
              <el-tag>{{ scope.row.state }}</el-tag>
            </template>
          </el-table-column>
          <el-table-column prop="startDate" label="Start date" width="150"/>
          <el-table-column label="Liquidity" width="150">
            <template #default="scope">
              <el-progress :percentage="scope.row.liquidity"/>
            </template>
          </el-table-column>
        </el-table>
      </el-main>
    </el-container>
  </div>
</template>

<script setup>
import {ref, onMounted} from 'vue'
import * as echarts from 'echarts'
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

const network = ref('eth')
const timeRange = ref('week')
const chartRef = ref(null)
const activeMenu = ref('1')

// 模拟数据
const vaultData = ref([
  {
    name: 'Bitcoin',
    price: '13,843.21',
    icon: 'https://cryptologos.cc/logos/bitcoin-btc-logo.png',
    daily: 213.8,
    balance: '$13,954.04',
    apy: '8.56%',
    state: 'Fixed',
    startDate: '05.10.2023',
    liquidity: 80
  },
  {
    name: 'Ethereum',
    price: '2,843.21',
    icon: 'https://cryptologos.cc/logos/ethereum-eth-logo.png',
    daily: 45.1,
    balance: '$3,954.04',
    apy: '5.44%',
    state: 'Fixed',
    startDate: '12.03.2023',
    liquidity: 60
  }
])

onMounted(() => {
  const chart = echarts.init(chartRef.value)
  const option = {
    grid: {
      top: 40,
      right: 20,
      bottom: 20,
      left: 40
    },
    xAxis: {
      type: 'category',
      data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
    },
    yAxis: {
      type: 'value'
    },
    series: [{
      data: [150, 230, 180, 280, 170, 320, 250],
      type: 'line',
      smooth: true,
      lineStyle: {
        color: '#ff6b00'
      },
      areaStyle: {
        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
          offset: 0,
          color: 'rgba(255, 107, 0, 0.4)'
        }, {
          offset: 1,
          color: 'rgba(255, 107, 0, 0)'
        }])
      }
    }]
  }
  chart.setOption(option)
})
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

.overview-header {
  margin-bottom: 20px;
}

.stat-cards .el-card {
  margin-bottom: 20px;
}

.amount {
  font-size: 24px;
  font-weight: bold;
  margin: 10px 0;
}

.change {
  font-size: 14px;
}

.positive {
  color: #67c23a;
}

.negative {
  color: #f56c6c;
}

.chart-card {
  margin-top: 20px;
}

.chart-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20px;
}

.vault-info {
  display: flex;
  align-items: center;
  gap: 10px;
}

.secondary-text {
  color: #909399;
  font-size: 12px;
}
</style>