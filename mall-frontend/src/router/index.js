import {createRouter, createWebHistory} from 'vue-router';
import LoginPage from '@/views/LoginPage.vue';
import RegisterPage from '@/views/RegisterPage.vue';
import LayoutVue from '@/views/Layout.vue';
import ProfileAvatar from '@/components/ProfileAvatar.vue';
import ProfileSettings from '@/components/ProfileSettings.vue';
import OrderList from '@/components/OrderList.vue';
import OrderHistory from '@/components/OrderHistory.vue';
import DashboardContent from '@/components/DashboardContent.vue';
const routes = [
    {
        path: '/',
        component: LayoutVue,
        children: [
            {
                path: '/profile/avatar',
                component: ProfileAvatar
            },
            {
                path: '/profile/setting',
                component: ProfileSettings
            },
            {
                path: '/orders/list',
                component: OrderList
            },
            {
                path: '/orders/history',
                component: OrderHistory
            },
            {
                path: '',
                component: DashboardContent// 可以根据需要重定向到默认页面
            }
        ]
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
    routes: routes,
});

export default router;