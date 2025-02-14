import './assets/main.css'

import {createApp} from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'; // 引入 Element Plus
import 'element-plus/dist/index.css'; // 引入 Element Plus 样式
import router from './router' // 引入路由配置
import {createPinia} from 'pinia';

const app = createApp(App);
const pinia = createPinia();
app.use(router);
app.use(ElementPlus);
app.use(pinia);
app.mount('#app');
