<template>
  <div class="home">
    <Header/>
    <el-carousel height="400px">
      <el-carousel-item v-for="item in promotions" :key="item.id">
        <img :src="item.image" class="promotion-image"/>
      </el-carousel-item>
    </el-carousel>
    <CategoryList/>
    <FeaturedProducts/>
    <Footer/>
  </div>
</template>

<script>
import Header from '@/components/layout/Header.vue'
import CategoryList from '@/components/home/CategoryList.vue'
import FeaturedProducts from '@/components/home/FeatureProduct.vue'
import Footer from '@/components/layout/Footer.vue'

export default {
  components: {
    Header,
    CategoryList,
    FeaturedProducts,
    Footer
  },
  // data() {
  //   return {
  //     promotions: [
  //       { id: 1, image: '/promotion1.jpg' },
  //       { id: 2, image: '/promotion2.jpg' },
  //       { id: 3, image: '/promotion3.jpg' }
  //     ]
  //   }
  // }
}
</script>