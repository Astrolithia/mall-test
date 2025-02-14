<template>
  <div class="product-detail">
    <el-row :gutter="24">
      <!-- 左侧图片区域 -->
      <el-col :span="12">
        <div class="product-images">
          <!-- 主图 -->
          <div class="main-image">
            <el-image :src="mainImage" fit="contain"></el-image>
          </div>
          <!-- 缩略图列表 -->
          <div class="thumbnail-list">
            <el-image
                v-for="(img, index) in thumbnails"
                :key="index"
                :src="img"
                @click="selectImage(index)"
                class="thumbnail"
            ></el-image>
          </div>
        </div>
      </el-col>

      <!-- 右侧商品信息 -->
      <el-col :span="12">
        <div class="product-info">
          <h1>经典款式T恤</h1>
          <div class="price">¥ 199.99</div>

          <!-- 颜色选择 -->
          <div class="select-section">
            <h3>选择颜色</h3>
            <el-radio-group v-model="selectedColor">
              <el-radio-button label="红色"></el-radio-button>
              <el-radio-button label="蓝色"></el-radio-button>
              <el-radio-button label="绿色"></el-radio-button>
              <el-radio-button label="黑色"></el-radio-button>
            </el-radio-group>
          </div>

          <!-- 尺码选择 -->
          <div class="select-section">
            <h3>选择尺码</h3>
            <el-select v-model="selectedSize" placeholder="请选择尺码">
              <el-option label="S" value="S"></el-option>
              <el-option label="M" value="M"></el-option>
              <el-option label="L" value="L"></el-option>
              <el-option label="XL" value="XL"></el-option>
            </el-select>
          </div>

          <!-- 数量选择 -->
          <div class="select-section">
            <h3>数量</h3>
            <el-input-number
                v-model="quantity"
                :min="1"
                :max="99"
                controls-position="right"
            ></el-input-number>
          </div>

          <!-- 商品描述 -->
          <div class="description">
            <h3>商品描述</h3>
            <p>这款经典T恤采用优质面料制作,舒适透气,适合日常穿着。多种颜色和尺码可选,满足不同需求。</p>
          </div>

          <!-- 按钮区域 -->
          <div class="button-group">
            <el-button type="primary" size="large" class="add-to-cart">
              加入购物车
            </el-button>
            <el-button size="large" class="add-to-wishlist">
              添加到收藏夹
            </el-button>
          </div>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script setup>
import {ref} from 'vue'

// 数据
const mainImage = ref('https://p3-pc-sign.douyinpic.com/tos-cn-i-0813c001/owPlgQghAoe1AIBEJCfyAsDzgoNkAAzENt8AzA~tplv-dy-aweme-images:q75.webp?biz_tag=aweme_images&from=327834062&lk3s=138a59ce&s=PackSourceEnum_SEARCH&sc=image&se=false&x-expires=1740211200&x-signature=3hgKRZ5gDHon%2F5QNfdkcHhaLjoI%3D')
const thumbnails = ref([
  'https://p3-pc-sign.douyinpic.com/tos-cn-i-0813c001/owPlgQghAoe1AIBEJCfyAsDzgoNkAAzENt8AzA~tplv-dy-aweme-images:q75.webp?biz_tag=aweme_images&from=327834062&lk3s=138a59ce&s=PackSourceEnum_SEARCH&sc=image&se=false&x-expires=1740211200&x-signature=3hgKRZ5gDHon%2F5QNfdkcHhaLjoI%3D',
  'https://p3-pc-sign.douyinpic.com/tos-cn-i-0813c001/owPlgQghAoe1AIBEJCfyAsDzgoNkAAzENt8AzA~tplv-dy-aweme-images:q75.webp?biz_tag=aweme_images&from=327834062&lk3s=138a59ce&s=PackSourceEnum_SEARCH&sc=image&se=false&x-expires=1740211200&x-signature=3hgKRZ5gDHon%2F5QNfdkcHhaLjoI%3D',
  'https://p3-pc-sign.douyinpic.com/tos-cn-i-0813c001/owPlgQghAoe1AIBEJCfyAsDzgoNkAAzENt8AzA~tplv-dy-aweme-images:q75.webp?biz_tag=aweme_images&from=327834062&lk3s=138a59ce&s=PackSourceEnum_SEARCH&sc=image&se=false&x-expires=1740211200&x-signature=3hgKRZ5gDHon%2F5QNfdkcHhaLjoI%3D',
  'https://p3-pc-sign.douyinpic.com/tos-cn-i-0813c001/owPlgQghAoe1AIBEJCfyAsDzgoNkAAzENt8AzA~tplv-dy-aweme-images:q75.webp?biz_tag=aweme_images&from=327834062&lk3s=138a59ce&s=PackSourceEnum_SEARCH&sc=image&se=false&x-expires=1740211200&x-signature=3hgKRZ5gDHon%2F5QNfdkcHhaLjoI%3D'
])
const selectedColor = ref('红色')
const selectedSize = ref('M')
const quantity = ref(1)

// 方法
const selectImage = (index) => {
  mainImage.value = thumbnails.value[index]
}
</script>

<style scoped>
.product-detail {
  padding: 20px;
}

.product-images {
  .main-image {
    margin-bottom: 20px;
    border: 1px solid #eee;
    padding: 10px;
  }

  .thumbnail-list {
    display: flex;
    gap: 10px;

    .thumbnail {
      width: 80px;
      height: 80px;
      border: 1px solid #ddd;
      cursor: pointer;

      &:hover {
        border-color: #409EFF;
      }
    }
  }
}

.product-info {
  h1 {
    font-size: 24px;
    margin-bottom: 20px;
  }

  .price {
    font-size: 28px;
    color: #f56c6c;
    margin-bottom: 30px;
  }

  .select-section {
    margin-bottom: 20px;

    h3 {
      margin-bottom: 10px;
      font-size: 16px;
    }
  }

  .description {
    margin: 30px 0;
    color: #666;
  }

  .button-group {
    display: flex;
    gap: 15px;

    .add-to-cart {
      flex: 2;
    }

    .add-to-wishlist {
      flex: 1;
    }
  }
}
</style>