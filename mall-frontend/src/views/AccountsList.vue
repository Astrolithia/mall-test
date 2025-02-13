<template>
  <el-card class="box-card">
    <template #header>
      <div class="card-header">
        <span>Accounts</span>
        <el-button class="button" type="text">View All</el-button>
      </div>
    </template>
    <el-table :data="accounts" style="width: 100%">
      <el-table-column prop="name" label="Account"></el-table-column>
      <el-table-column prop="balance" label="Balance"></el-table-column>
    </el-table>
  </el-card>
</template>

<script setup>
import {ref} from 'vue'

const accounts = ref([
  {name: 'Main Savings', balance: '$8,459.45'},
  {name: 'Checking Account', balance: '$2,850.00'},
  {name: 'Investment Portfolio', balance: '$15,230.80'},
  {name: 'Credit Card', balance: '-$1,200.00'},
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