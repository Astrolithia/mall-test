import {createRouter, createWebHistory} from 'vue-router';
import Dashboard from '@/views/Dashboard.vue';
import LoginRegister from "@/views/LoginRegister.vue"; // 引入组件

const routes = [
    {
        path: '/',
        component: Dashboard
    }, // 配置路由
    {
        path: '/login',
        component: LoginRegister
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;