<script setup>
import {ref, onMounted} from 'vue'
import * as echarts from 'echarts'

const timeRange = ref('week')
const chartRef = ref(null)

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

<template>
  <div>
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
  </div>
</template>