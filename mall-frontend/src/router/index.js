import {createRouter, createWebHistory} from 'vue-router'
import Home from '@/views/index.vue'
import ProductDetail from '@/views/ProductDetail.vue'
// import Layout from '@/views/Layout.vue'

const routes = [
    {
        path: '/',
        component: Home
    },
    // 确保路径正确且组件存在
    {
        path: '/product/:id',
        name: 'ProductDetail',
        component: () => import('@/views/ProductDetail.vue') // 注意路径是否正确
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router