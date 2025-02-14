import axios from 'axios'
import {ElMessage} from 'element-plus'
import {useTokenStore} from '@/shared/store/token.js'

const request = axios.create({
    baseURL: '/api',
    timeout: 5000
})

// 请求拦截器
request.interceptors.request.use(
    (config) => {
        // const tokenStore = useTokenStore()
        // // 如果有token，则添加到请求头中
        // if (tokenStore.token) {
        //     config.headers.Authorization = `Bearer ${tokenStore.token}`
        // }
        return config
    },
    (error) => {
        return Promise.reject(error)
    }
)

// 响应拦截器
request.interceptors.response.use(
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