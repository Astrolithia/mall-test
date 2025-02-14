import {createRouter, createWebHistory} from 'vue-router';
import Dashboard from '@/views/Dashboard.vue';
import LoginPage from '@/views/LoginPage.vue';
import RegisterPage from '@/views/RegisterPage.vue';
const routes = [
    {
        path: '/',
        component: Dashboard,
    }, // 配置路由
    {
        path: '/login',
        component: LoginPage
    },
    {
        path: '/register',
        component: RegisterPage
    },
    // {
    //     path: '/profile',
    //     name: 'Profile',
    //     component: () => import('../views/profile/ProfileLayout.vue'),
    //     children: [
    //         {
    //             path: 'settings',
    //             name: 'ProfileSettings',
    //             component: () => import('../views/profile/ProfileSettings.vue')
    //         },
    //         {
    //             path: 'avatar',
    //             name: 'AvatarSettings',
    //             component: () => import('../views/profile/AvatarSettings.vue')
    //         }
    //     ]
    // },
    // {
    //     path: '/orders',
    //     name: 'Orders',
    //     component: () => import('../views/orders/OrdersLayout.vue'),
    //     children: [
    //         {
    //             path: 'list',
    //             name: 'OrderList',
    //             component: () => import('../views/orders/OrderList.vue')
    //         },
    //         {
    //             path: 'history',
    //             name: 'OrderHistory',
    //             component: () => import('../views/orders/OrderHistory.vue')
    //         }
    //     ]
    // },
    // {
    //     path: '/settings',
    //     name: 'Settings',
    //     component: () => import('../views/Settings.vue')
    // }
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;