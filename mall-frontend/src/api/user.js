// 导入request.js请求工具
import request from '@/utils/request.js'

// 提供调用注册接口的函数
export const userRegisterService = (loginForm) => {
    // 借助于UrlSearchParams完成传递
    const params = new URLSearchParams()
    for (let key in loginForm) {
        params.append(key, loginForm[key]);
    }
    return request.post('/user/register', loginForm);
}