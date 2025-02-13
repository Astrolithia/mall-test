import {createRouter, createWebHistory} from 'vue-router';
import Dashboard from '@/views/Dashboard.vue';
import LoginRegister from "@/views/LoginRegister.vue"; // 引入组件
import LoginPage from '@/views/LoginPage.vue';
import RegisterPage from '@/views/RegisterPage.vue';
const routes = [
    {
        path: '/',
        component: Dashboard
    }, // 配置路由
    {
        path: '/login',
        component: LoginPage
    },
    {
        path: '/register',
        component: RegisterPage
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;