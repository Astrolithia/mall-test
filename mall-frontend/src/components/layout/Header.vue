<template>
  <div class="header">
    <div class="header-content">
      <h1 class="logo">ShopNow</h1>
      <el-input
          v-model="searchText"
          placeholder="搜索商品..."
          prefix-icon="el-icon-search"
          class="search-input"
      />
      <div class="header-actions">
        <el-button icon="el-icon-shopping-cart-2" circle></el-button>
        <el-button icon="el-icon-user" circle></el-button>
      </div>
    </div>
  </div>
</template>

<style scoped>
.header {
  padding: 1rem;
  border-bottom: 1px solid #eee;
}

.header-content {
  display: flex;
  align-items: center;
  max-width: 1200px;
  margin: 0 auto;
}

.logo {
  margin-right: 2rem;
}

.search-input {
  width: 400px;
}

.header-actions {
  margin-left: auto;
}
</style>