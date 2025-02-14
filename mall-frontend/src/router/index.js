import {createRouter, createWebHistory} from 'vue-router'
import Home from '@/views/index.vue'
// import Layout from '@/views/Layout.vue'

const routes = [
    {
        path: '/',
        component: Home
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router