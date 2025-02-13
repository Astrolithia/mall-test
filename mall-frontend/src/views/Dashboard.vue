<template>
  <div class="dashboard">
    <el-row :gutter="20">
      <el-col :span="12">
        <AccountsList/>
      </el-col>
      <el-col :span="12">
        <TransactionsList/>
      </el-col>
    </el-row>
    <el-row :gutter="20" style="margin-top: 20px;">
      <el-col :span="24">
        <UpcomingEvents/>
      </el-col>
    </el-row>
  </div>
</template>

<script setup>
import AccountsList from './AccountsList.vue'
import TransactionsList from './TransactionsList.vue'
import UpcomingEvents from './UpcomingEvents.vue'
</script>