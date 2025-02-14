<template>
  <footer class="footer">
    <div class="footer-content">
      <div class="footer-section">
        <h3>关于我们</h3>
        <ul>
          <li><a href="#">公司简介</a></li>
          <li><a href="#">联系方式</a></li>
        </ul>
      </div>

      <div class="footer-section">
        <h3>客户服务</h3>
        <ul>
          <li><a href="#">订单查询</a></li>
          <li><a href="#">退换货政策</a></li>
        </ul>
      </div>

      <div class="footer-section">
        <h3>商务合作</h3>
        <ul>
          <li><a href="#">成为供应商</a></li>
          <li><a href="#">广告投放</a></li>
        </ul>
      </div>

      <div class="footer-section">
        <h3>关注我们</h3>
        <ul>
          <li><a href="#">微信公众号</a></li>
          <li><a href="#">新浪微博</a></li>
        </ul>
      </div>
    </div>
    <div class="footer-bottom">
      <p>© 2024 ShopNow. All rights reserved.</p>
    </div>
  </footer>
</template>

<style scoped>
.footer {
  background-color: #f8f9fa;
  padding: 3rem 0 1rem;
  margin-top: 3rem;
}

.footer-content {
  max-width: 1200px;
  margin: 0 auto;
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 2rem;
  padding: 0 1rem;
}

.footer-section h3 {
  font-size: 1.1rem;
  margin-bottom: 1rem;
  color: #333;
}

.footer-section ul {
  list-style: none;
  padding: 0;
}

.footer-section li {
  margin-bottom: 0.5rem;
}

.footer-section a {
  color: #666;
  text-decoration: none;
  font-size: 0.9rem;
}

.footer-section a:hover {
  color: #409EFF;
}

.footer-bottom {
  text-align: center;
  margin-top: 2rem;
  padding-top: 1rem;
  border-top: 1px solid #eee;
}

.footer-bottom p {
  color: #999;
  font-size: 0.9rem;
}
</style>