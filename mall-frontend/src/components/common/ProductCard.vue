<template>
  <el-card class="product-card" shadow="hover" @click="navigateToDetail">
    <div class="product-image-container">
      <el-image
          :src="product.image"
          fit="cover"
          :preview-src-list="[product.image]"
          class="product-image"
      >
        <template #error>
          <div class="image-error">
            <el-icon>
              <Picture/>
            </el-icon>
          </div>
        </template>
      </el-image>
      <div class="product-tags" v-if="product.tags && product.tags.length">
        <el-tag
            v-for="tag in product.tags"
            :key="tag"
            size="small"
            class="product-tag"
        >
          {{ tag }}
        </el-tag>
      </div>
    </div>

    <div class="product-info">
      <h3 class="product-title">{{ product.name }}</h3>
      <p class="product-description">{{ product.description }}</p>

      <div class="product-footer">
        <span class="product-price">¥{{ formatPrice(product.price) }}</span>
        <div class="product-actions">
          <el-button
              type="primary"
              size="small"
              circle
              @click.stop="addToCart"
          >
            <el-icon>
              <ShoppingCart/>
            </el-icon>
          </el-button>
          <el-button
              type="danger"
              size="small"
              circle
              @click.stop="toggleFavorite"
          >
            <el-icon>
              <Star/>
            </el-icon>
          </el-button>
        </div>
      </div>
    </div>
  </el-card>
</template>

<script>
import {Picture, ShoppingCart, Star} from '@element-plus/icons-vue'
import {ElMessage} from 'element-plus'

export default {
  name: 'ProductCard',
  components: {
    Picture,
    ShoppingCart,
    Star
  },
  props: {
    product: {
      type: Object,
      required: true,
      default: () => ({
        id: '',
        name: '',
        description: '',
        price: 0,
        image: '',
        tags: []
      })
    }
  },
  methods: {
    formatPrice(price) {
      return Number(price).toFixed(2)
    },
    navigateToDetail() {
      this.$router.push(`/product/${this.product.id}`)
    },
    addToCart() {
      // 触发添加到购物车事件
      this.$emit('add-to-cart', this.product)
      ElMessage({
        message: '已添加到购物车',
        type: 'success'
      })
    },
    toggleFavorite() {
      // 触发收藏事件
      this.$emit('toggle-favorite', this.product)
      ElMessage({
        message: '已添加到收藏',
        type: 'success'
      })
    }
  }
}
</script>

<style scoped>
.product-card {
  height: 100%;
  display: flex;
  flex-direction: column;
}

.product-image-container {
  position: relative;
  padding-top: 100%; /* 1:1 Aspect Ratio */
}

.product-image {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}

.image-error {
  height: 100%;
  background: #f5f7fa;
  display: flex;
  align-items: center;
  justify-content: center;
  color: #909399;
}

.product-tags {
  position: absolute;
  top: 10px;
  left: 10px;
  z-index: 1;
}

.product-tag {
  margin-right: 5px;
}

.product-info {
  padding: 12px;
  flex-grow: 1;
  display: flex;
  flex-direction: column;
}

.product-title {
  margin: 0 0 8px;
  font-size: 16px;
  font-weight: 500;
  color: #303133;
}

.product-description {
  margin: 0 0 12px;
  font-size: 14px;
  color: #606266;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 2;
  overflow: hidden;
}

.product-footer {
  margin-top: auto;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.product-price {
  font-size: 18px;
  font-weight: bold;
  color: #ff6b6b;
}

.product-actions {
  display: flex;
  gap: 8px;
}
</style>