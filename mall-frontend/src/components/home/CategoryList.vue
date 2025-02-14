<template>
  <div class="category-section">
    <h2>热门分类</h2>
    <div class="category-grid">
      <el-card
          v-for="category in categories"
          :key="category.id"
          class="category-card"
          shadow="hover"
      >
        <div class="category-content">
          <span>{{ category.name }}</span>
          <el-icon>
            <arrow-right/>
          </el-icon>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      categories: [
        {id: 1, name: '电子产品'},
        {id: 2, name: '服装'},
        {id: 3, name: '家居'},
        {id: 4, name: '美妆'}
      ]
    }
  }
}
</script>
<style scoped>
.category-section {
  max-width: 1200px;
  margin: 2rem auto;
  padding: 0 1rem;
}

.category-grid {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 1rem;
  margin-top: 1rem;
}

.category-card {
  cursor: pointer;
}

.category-content {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 1rem;
}
</style>