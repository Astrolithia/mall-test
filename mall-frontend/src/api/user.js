import request from '@/utils/request.js'

export const userRegisterService = (loginForm) => {
    const params = new URLSearchParams()
    for (let key in loginForm) {
        params.append(key, loginForm[key]);
    }
    return request.post('/user/register', params);
}

export const userLoginService = (loginForm) => {
    const params = new URLSearchParams()
    for (let key in loginForm) {
        params.append(key, loginForm[key]);
    }
    return request.post('/user/login', params);
}