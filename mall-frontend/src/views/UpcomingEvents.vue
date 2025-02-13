<template>
  <el-card class="box-card">
    <template #header>
      <div class="card-header">
        <span>Upcoming Events</span>
      </div>
    </template>
    <el-timeline>
      <el-timeline-item
          v-for="(event, index) in events"
          :key="index"
          :timestamp="event.date"
          :type="event.type"
      >
        {{ event.content }}
      </el-timeline-item>
    </el-timeline>
  </el-card>
</template>

<script setup>
import {ref} from 'vue'

const events = ref([
  {content: 'Credit Card Payment Due', date: '2023-06-20', type: 'warning'},
  {content: 'Quarterly Tax Payment', date: '2023-06-25', type: 'danger'},
  {content: 'Savings Goal Milestone', date: '2023-06-30', type: 'success'},
])
</script>

<style scoped>
.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
</style>