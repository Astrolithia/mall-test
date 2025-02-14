<template>
  <div class="featured-products">
    <h2>特色商品</h2>
    <div class="products-grid">
      <el-card
          v-for="product in products"
          :key="product.id"
          class="product-card"
          shadow="hover"
      >
        <img :src="product.image" class="product-image"/>
        <h3>{{ product.name }}</h3>
        <p>{{ product.description }}</p>
        <div class="product-price">
          <span>¥{{ product.price }}</span>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      products: [
        {
          id: 1,
          name: '商品名称',
          description: '简短描述',
          price: '199.99',
          image: 'https://img.alicdn.com/imgextra/i3/O1CN01FgNOZh1W5Q9ITwqYw_!!6000000002735-0-tps-946-946.jpg'
        },
        {
          id: 2,
          name: '商品名称',
          description: '简短描述',
          price: '199.99',
          image: 'https://img.alicdn.com/imgextra/i1/O1CN01KyQZz01nCGqNwXd3x_!!6000000005058-0-tps-946-946.jpg'
        },
        {
          id: 3,
          name: '商品名称',
          description: '简短描述',
          price: '199.99',
          image: 'https://img.alicdn.com/imgextra/i2/O1CN01IMPeD11PPcYM2h3B6_!!6000000001842-0-tps-946-946.jpg'
        },
        {
          id: 4,
          name: '商品名称',
          description: '简短描述',
          price: '199.99',
          image: 'https://img.alicdn.com/imgextra/i4/O1CN01Xt9m8F1mzjyqBQFNp_!!6000000005024-0-tps-946-946.jpg'
        }
      ]
    }
  }
}
</script>

<style scoped>
.featured-products {
  max-width: 1200px;
  margin: 2rem auto;
  padding: 0 1rem;
}

.products-grid {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 1.5rem;
  margin-top: 1rem;
}

.product-card {
  cursor: pointer;
  transition: transform 0.3s;
}

.product-card:hover {
  transform: translateY(-5px);
}

.product-image {
  width: 100%;
  height: 200px;
  object-fit: cover;
}

.product-price {
  color: #ff6b6b;
  font-size: 1.2rem;
  font-weight: bold;
  margin-top: 0.5rem;
}
</style>