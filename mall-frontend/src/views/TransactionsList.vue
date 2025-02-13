<template>
  <el-card class="box-card">
    <template #header>
      <div class="card-header">
        <span>Recent Transactions</span>
        <el-button class="button" type="text">View All</el-button>
      </div>
    </template>
    <el-table :data="transactions" style="width: 100%">
      <el-table-column prop="description" label="Description"></el-table-column>
      <el-table-column prop="amount" label="Amount"></el-table-column>
      <el-table-column prop="date" label="Date"></el-table-column>
    </el-table>
  </el-card>
</template>

<script setup>
import {ref} from 'vue'

const transactions = ref([
  {description: 'Grocery Shopping', amount: '-$120.50', date: '2023-06-15'},
  {description: 'Salary Deposit', amount: '+$3,500.00', date: '2023-06-14'},
  {description: 'Electric Bill', amount: '-$85.20', date: '2023-06-13'},
  {description: 'Online Purchase', amount: '-$65.99', date: '2023-06-12'},
])
</script>

<style scoped>
.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.button {
  padding: 0;
  min-height: auto;
}
</style>