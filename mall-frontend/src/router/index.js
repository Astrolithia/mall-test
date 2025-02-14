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
    //     component: () => import('../components/ProfileLayout.vue'),
    //     children: [
    //       {
    //         path: 'settings',
    //         name: 'ProfileSettings',
    //         component: () => import('../components/ProfileSettings.vue')
    //       },
    //       {
    //         path: 'avatar',
    //         name: 'AvatarSettings',
    //         component: () => import('../components/ProfileAvatar.vue')
    //       }
    //     ]
    // },
    // {
    //     path: '/orders',
    //     name: 'Orders',
    //     component: () => import('../components/OrdersLayout.vue'),
    //     children: [
    //       {
    //         path: 'list',
    //         name: 'OrderList',
    //         component: () => import('../components/OrderList.vue')
    //       },
    //       {
    //         path: 'history',
    //         name: 'OrderHistory',
    //         component: () => import('../components/OrderHistory.vue')
    //       }
    //     ]
    //   },
    //   {
    //     path: '/settings',
    //     name: 'Settings',
    //     component: () => import('../components/Settings.vue')
    //   }
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;