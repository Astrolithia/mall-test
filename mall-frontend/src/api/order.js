import request from "@/utils/request.js";

// 文章分类列表查询
export const orderListService = () => {
    return request.get('/order/list')
}