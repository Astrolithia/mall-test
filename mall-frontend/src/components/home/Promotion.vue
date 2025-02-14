<template>
  <el-carousel height="400px">
    <el-carousel-item v-for="item in promotions" :key="item.id">
      <img :src="item.image" class="promotion-image"/>
    </el-carousel-item>
  </el-carousel>
</template>

<script>
export default {
  data() {
    return {
      promotions: [
        {
          id: 1,
          image: 'https://img.alicdn.com/imgextra/i4/O1CN01Tk0HTo1zv7pxzgxXz_!!6000000006773-0-tps-846-472.jpg'
        },
        {
          id: 2,
          image: 'https://img.alicdn.com/imgextra/i2/O1CN01F1BLRU1y33LJLL0qA_!!6000000006519-0-tps-846-472.jpg'
        },
        {
          id: 3,
          image: 'https://img.alicdn.com/imgextra/i2/O1CN01xPe9mj1kV3YgXwnCk_!!6000000004685-0-tps-846-472.jpg'
        }
      ]
    }
  }
}
</script>

<style scoped>
.promotion-image {
  width: 100%;
  height: 100%;
  object-fit: cover;
}
</style>