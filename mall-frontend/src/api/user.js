import request from '@/utils/request.js'

export const userRegisterService = (loginForm) => {
    // 直接使用 URLSearchParams 构建查询字符串
    // const queryString = new URLSearchParams({
    //     username: loginForm.username,
    //     password: loginForm.password,
    //     email: loginForm.email,
    //     phone: loginForm.phone
    // }).toString()

    // return request({
    //     method: 'post',
    //     url: `/user/register?${queryString}`,  // 直接在URL中附加查询参数
    //     headers: {
    //         'Content-Type': 'application/x-www-form-urlencoded'
    //     }
    // })
    
    const params = new URLSearchParams()
    for (let key in loginForm) {
        params.append(key, loginForm[key]);
    }
    return request.post('/user/register', params);

    // return request({
    //     method: 'post',
    //     url: '/user/register',
    //     params: {  // 使用 params 而不是在 url 中拼接
    //         username: loginForm.username,
    //         password: loginForm.password,
    //         email: loginForm.email,
    //         phone: loginForm.phone
    //     },
    //     headers: {
    //         'Content-Type': 'application/x-www-form-urlencoded'
    //     }
    // })

}
// import request from '@/utils/request.js'
//
// export const userRegisterService = (loginForm) => {
//     const { username, password, email, phone } = loginForm
//
//     // 检查数据
//     console.log('注册请求数据:', {
//         username,
//         password,
//         email,
//         phone
//     })
//
//     // 检查请求参数
//     const params = {
//         username,
//         password,
//         email,
//         phone
//     }
//     console.log('请求参数:', params)
//
//     return request({
//         method: 'post',
//         url: '/user/register',
//         params: params,
//         headers: {
//             'Content-Type': 'application/x-www-form-urlencoded'
//         }
//     })
// }