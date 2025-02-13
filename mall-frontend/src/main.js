import './assets/main.css'

import {createApp} from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'; // 引入 Element Plus
import 'element-plus/dist/index.css'; // 引入 Element Plus 样式
import router from './router' // 引入路由配置

const app = createApp(App);
app.use(router);
app.use(ElementPlus);
app.mount('#app');
