<script setup>
import {Edit, Delete} from '@element-plus/icons-vue'
import {ref} from 'vue'
import {orderListService} from '@/api/order.js';
import {ElMessage} from 'element-plus'

const orders = ref([
  {
    "orderId": 6,
    "userId": 1,
    "merchantId": 1,
    "orderStatus": "待支付",
    "paymentStatus": "未支付",
    "paymentTime": null,
    "orderTotal": 150.50,
    "shippingStatus": "未发货",
    "shippingTime": null,
    "createTime": "2025-02-10T17:45:13",
    "updateTime": "2025-02-10T17:45:13"
  },
  {
    "orderId": 2,
    "userId": 1,
    "merchantId": 1,
    "orderStatus": "待支付",
    "paymentStatus": "未支付",
    "paymentTime": null,
    "orderTotal": 150.50,
    "shippingStatus": "未发货",
    "shippingTime": null,
    "createTime": "2025-02-10T15:22:01",
    "updateTime": "2025-02-10T15:22:01"
  }
])

const orderList = async () => {
  let result = await orderListService();
  orders.value = result.data.items;
}
orderList()

</script>

<template>
  <el-card class="page-container">
    <template #header>
      <div class="header">
        <span>订单列表</span>
        <div class="extra">
          <el-button type="primary">创建订单</el-button>
        </div>
      </div>
    </template>
    <el-table :data="orders" style="width: 100%">
      <el-table-column label="序号" width="80" type="index"></el-table-column>
      <el-table-column label="订单编号" prop="orderId" width="100"></el-table-column>
      <el-table-column label="订单金额" width="120">
        <template #default="{ row }">
          ¥{{ row.orderTotal.toFixed(2) }}
        </template>
      </el-table-column>
      <el-table-column label="订单状态" width="100">
        <template #default="{ row }">
          <el-tag :type="row.orderStatus === '待支付' ? 'warning' : 'success'">
            {{ row.orderStatus }}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column label="支付状态" width="100">
        <template #default="{ row }">
          <el-tag :type="row.paymentStatus === '未支付' ? 'warning' : 'success'">
            {{ row.paymentStatus }}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column label="发货状态" width="100">
        <template #default="{ row }">
          <el-tag :type="row.shippingStatus === '未发货' ? 'info' : 'success'">
            {{ row.shippingStatus }}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column label="创建时间" width="180">
        <template #default="{ row }">
          {{ new Date(row.createTime).toLocaleString() }}
        </template>
      </el-table-column>
      <el-table-column label="操作" width="120">
        <template #default="{ row }">
          <el-button :icon="Edit" circle plain type="primary"
                     @click="viewOrderDetail(row.orderId)"></el-button>
          <el-button :icon="Delete" circle plain type="danger"
                     @click="cancelOrder(row.orderId)"></el-button>
        </template>
      </el-table-column>
      <template #empty>
        <el-empty description="没有数据"/>
      </template>
    </el-table>
  </el-card>
</template>

<style scoped>
.page-container {
  min-height: 100%;
  box-sizing: border-box;

  .header {
    display: flex;
    align-items: center;
    justify-content: space-between;
  }
}

.el-tag {
  width: 60px;
  text-align: center;
}

:deep(.el-table .cell) {
  text-align: center;
}
</style>