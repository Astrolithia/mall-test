// //定制请求的实例

// //导入axios  npm install axios
// import axios from 'axios';
// //定义一个变量,记录公共的前缀  ,  baseURL
// // const baseURL = 'http://localhost:8080';
// const baseURL = '/api';
// const instance = axios.create({baseURL});


// //添加响应拦截器
// instance.interceptors.response.use(
//     result => {
//         return result.data;
//     },
//     err => {
//         alert('服务异常');
//         return Promise.reject(err);//异步的状态转化成失败的状态
//     }
// )

// export default instance;

import axios from 'axios'
import {ElMessage} from 'element-plus'

const request = axios.create({
    baseURL: '/api',
    timeout: 5000
})

// 请求拦截器
request.interceptors.request.use(
    config => {
        // 打印完整的请求信息
        console.log('Request Config:', {
            url: config.url,
            method: config.method,
            params: config.params,
            headers: config.headers,
            baseURL: config.baseURL
        })
        return config
    },

    error => {
        console.error('Request Error:', error)
        return Promise.reject(error)
    }
)

// 响应拦截器
request.interceptors.response.use(
    // response => {
    //     console.log('Response Success:', response.data)
    //     return response.data
    // },
    result => {
        // 判断业务状态码
        if (result.data.code === 0) {
            return result.data;
        }
        // 操作失败
        alert(result.data.msg ? result.data.msg : '服务异常')
        // 异步操作的状态转换为失败
        return Promise.reject(result.data)
    },
    error => {
        console.error('Response Error:', {
            status: error.response?.status,
            statusText: error.response?.statusText,
            data: error.response?.data,
            config: error.config,
            headers: error.response?.headers
        })

        if (error.response?.status === 401) {
            ElMessage.error('未授权访问,请检查接口权限')
        } else {
            ElMessage.error(error.message || '请求失败')
        }
        return Promise.reject(error)
    }
)

export default request