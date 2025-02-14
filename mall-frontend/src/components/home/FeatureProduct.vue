<template>
  <div class="featured-products">
    <h2>特色商品</h2>
    <div class="products-grid">
      <el-card
          v-for="product in products"
          :key="product.id"
          class="product-card"
          shadow="hover"
          @click.native="$router.push(`/product/${product.id}`)"
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
          image: 'https://p3-pc-sign.douyinpic.com/tos-cn-i-0813c001/owPlgQghAoe1AIBEJCfyAsDzgoNkAAzENt8AzA~tplv-dy-aweme-images:q75.webp?biz_tag=aweme_images&from=327834062&lk3s=138a59ce&s=PackSourceEnum_SEARCH&sc=image&se=false&x-expires=1740211200&x-signature=3hgKRZ5gDHon%2F5QNfdkcHhaLjoI%3D'
        },
        {
          id: 2,
          name: '商品名称',
          description: '简短描述',
          price: '199.99',
          image: 'https://p3-pc-sign.douyinpic.com/tos-cn-i-0813c001/owPlgQghAoe1AIBEJCfyAsDzgoNkAAzENt8AzA~tplv-dy-aweme-images:q75.webp?biz_tag=aweme_images&from=327834062&lk3s=138a59ce&s=PackSourceEnum_SEARCH&sc=image&se=false&x-expires=1740211200&x-signature=3hgKRZ5gDHon%2F5QNfdkcHhaLjoI%3D'
        },
        {
          id: 3,
          name: '商品名称',
          description: '简短描述',
          price: '199.99',
          image: 'https://p3-pc-sign.douyinpic.com/tos-cn-i-0813c001/owPlgQghAoe1AIBEJCfyAsDzgoNkAAzENt8AzA~tplv-dy-aweme-images:q75.webp?biz_tag=aweme_images&from=327834062&lk3s=138a59ce&s=PackSourceEnum_SEARCH&sc=image&se=false&x-expires=1740211200&x-signature=3hgKRZ5gDHon%2F5QNfdkcHhaLjoI%3D'
        },
        {
          id: 4,
          name: '商品名称',
          description: '简短描述',
          price: '199.99',
          image: 'https://p3-pc-sign.douyinpic.com/tos-cn-i-0813c001/owPlgQghAoe1AIBEJCfyAsDzgoNkAAzENt8AzA~tplv-dy-aweme-images:q75.webp?biz_tag=aweme_images&from=327834062&lk3s=138a59ce&s=PackSourceEnum_SEARCH&sc=image&se=false&x-expires=1740211200&x-signature=3hgKRZ5gDHon%2F5QNfdkcHhaLjoI%3D'
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