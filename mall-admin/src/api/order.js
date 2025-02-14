import request from "@/utils/request.js";
import {useTokenStore} from "@/store/token.js";

// 文章分类列表查询
export const orderListService = () => {
    const tokenStore = useTokenStore();
    return request.get('/order/list', {
        headers: {
            'Authorization': tokenStore.token
        }
    })
}