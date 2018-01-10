# JSPTraining
#### 手机销售系统
#### 本次我们的实训选题选择的是手机销售系统，其中，我们把该系统分为了**用户模块**，**购物车模块**，**订单模块**，**订单详情模块**和**产品模块**。
#### 设计思想：我们采用的前后端分离开发，使用json进行数据的交互。同时，我们在开始项目前，进行了与手机销售系统有关的讨论。确定我们的接口的定义，数据表的建立和该系统的相关优化。
#### 系统功能：顾名思义，该系统是为了销售手机而开发。
     1，用户-->注册登录，忘记密码找回密码，更新个人用户信息等。
     2，购物车-->增加，删除，更新购物车等，主要是商品的选购。
     3，订单-->在购物车的物品可以生成订单，主要是结算功能。
     4，订单详情-->已经生成订单的，可以详细的查询订单内的产品详细，生成订单的时间，价格等信息，主要的是打印清单。
     5，产品-->可以查看所有已经上架的手机。
#### 以下是接口文档 :simple_smile: :simple_smile:
[用户模块](#用户模块) <br>
[购物车模块](#购物车模块) <br>
[订单模块](#订单模块)<br>
[产品模块](#产品模块)<br>
[订单详情模块](#订单详情模块)<br>
#### 用户模块
<br>
- login.do<br>
http://localhost:8080/user/login.do<br>
输出<br>
{<br>
  "username": "simple",<br>
  "password": "123123123"<br>
}<br>
输出<br>
{<br>
"status": 1,<br>
"msg": "SUCCESS",<br>
"data":{<br>
"id": 15,<br>
"username": "simple",<br>
"password": "",<br>
"email": "crescentcxm@gmail.com",<br>
"phone": "??????????",<br>
"question": "没有bug",<br>
"answer": "是的",<br>
"role": 1,<br>
"createTime": 1514298249000,<br>
"updateTime": 1514298249000<br>
},<br>
"success": true<br>
}<br>
- register.do<br>
http://localhost:8080/user/register.do<br>
输入<br>
{<br>
  "username": "huangbude",<br>
  "password": "123123123",<br>
  "email":"673724357@qq.com",<br>
  "phone":"??????????",<br>
  "question":"好不好",<br>
  "answer":"好"<br>
}<br>
输出<br>
{<br>
"status": 1,<br>
"msg": "注册成功",<br>
"data": null,<br>
"success": true<br>
}<br>
- update_user_email.do<br>
http://localhost:8080/user/update_user_email.do<br>
输入<br>
{<br>
  "email":"crescentcxm@gmail.com"<br>
}<br>
输出<br>
{<br>
"status": 1,<br>
"msg": "邮箱已经存在",<br>
"data": null,
"success": false<br>
}<br>
- update_user_phone.do<br>
http://localhost:8080/user/update_user_phone.do<br>
输入 <br>
{<br>
  "phone":"???????????"<br>
}<br>
输出<br>
{<br>
"status": 1,<br>
"msg": "修改手机号码成功",<br>
"data": null,<br>
"success": true<br>
}<br>
- update_user_password.do<br>
http://localhost:8080/user/update_user_password.do<br>
输入<br>
{<br>
  "oldPassword":"123123123",<br>
  "newPassword":"asdasdasd"<br>
}<br>
输出<br>
{<br>
"status": 1,<br>
"msg": "修改密码成功",<br>
"data": null,<br>
"success": true<br>
}<br>
- forget_password_check_answer.do<br>
http://localhost:8080/user/forget_password_check_answer.do<br>
输入<br>
{<br>
  "username":"huangbude",<br>
  "question":"好不好",<br>
  "answer":"好"<br>
}<br>
输出<br>
{<br>
"status": 1,<br>
"msg": "获取token成功",<br>
"data": "583c72ff-7adf-4e5c-8bfe-4f539f4d7a62",<br>
"success": true<br>
}<br>
- reset_password.do<br>
http://localhost:8080/user/reset_password.do<br>
输入<br>
{<br>
  "username":"huangbude",<br>
  "newPassword":"123123123",<br>
  "forgetToken":"583c72ff-7adf-4e5c-8bfe-4f539f4d7a62"<br>
}<br>
输出<br>
{<br>
"status": 1,<br>
"msg": "修改密码成功",<br>
"data": null,<br>
"success": true<br>
}<br>
- logout.do<br>
http://localhost:8080/user/logout.do<br>
输入<br>
{<br>
}<br>
输出<br>
{<br>
"status": 1,<br>
"msg": "登出成功",<br>
"data": null,<br>
"success": true<br>
}<br>
- get_user_information.do<br>
http://localhost:8080/user/get_user_information.do<br>
输入<br>
{<br>
}<br>
输出<br>
{<br>
"status": 1,<br>
"msg": "查询成功",<br>
"data":{<br>
"id": 15,<br>
"username": "simple",<br>
"password": "",<br>
"email": "crescentcxm@gmail.com",<br>
"phone": "???????????",<br>
"question": "没有bug",<br>
"answer": "是的",<br>
"role": 1,<br>
"createTime": 1514298249000,<br>
"updateTime": 1514298249000<br>
},<br>
"success": true<br>
}<br>
- update_question_and_answer.do<br>
http://localhost:8080/user/update_question_and_answer.do<br>
输入<br>
{<br>
  "question":"没有bug",<br>
  "answer":"是的"<br>
}<br>
输出<br>
{<br>
"status": 1,<br>
"msg": "修改问题和答案成功",<br>
"data": null,<br>
"success": true<br>
}<br>

#### 购物车模块
- add_shipping_address.do<br>
http://localhost:8080/shipping/add_shipping_address.do<br>
输入<br>
{<br>
  "receiverName":"huangbude",<br>
  "receiverPhone":"",<br>
  "receiverMobile":"???????????",<br>
  "receiverProvince":"广东省",<br>
  "receiverCity":"东莞市",<br>
  "receiverDistrict":"南城区",<br>
  "receiverAddress":"广东科技学院",<br>
  "receiverZip":"523000"<br>
}<br>
输出<br>
{<br>
"status": 1,<br>
"msg": "新建收货地址成功",<br>
"data": null,<br>
"success": true<br>
}<br>
- delete_shipping_address.do<br>
http://localhost:8080/shipping/delete_shipping_address.do<br>
输入<br>
{<br>
  "shippingId":"17"<br>
}<br>
输出<br>
{<br>
"status": 1,<br>
"msg": "删除收货地址失败",<br>
"data": null,<br>
"success": false<br>
}<br>
- get_shipping_address.do<br>
http://localhost:8080/shipping/get_shipping_address.do<br>
输入<br>
{<br>
  "pageNum":"1",<br>
  "pageSize":"5"<br>
}<br>
输出<br>
{<br>
"status": 1,<br>
"msg": "查询到该用户的收货地址",<br>
"data":{<br>
"pageNum": 1,<br>
"pageSize": 5,<br>
"size": 5,<br>
"startRow": 1,<br>
"endRow": 5,<br>
"total": 9,<br>
"pages": 2,<br>
"list":[{"id": 13, "userId": 16, "receiverName": "陈新谋", "receiverPhone": "",…],<br>
"prePage": 0,<br>
"nextPage": 2,<br>
"isFirstPage": true,<br>
"isLastPage": false,<br>
"hasPreviousPage": false,<br>
"hasNextPage": true,<br>
"navigatePages": 8,<br>
"navigatepageNums":[<br>
1,<br>
2<br>
],<br>
"navigateFirstPage": 1,<br>
"navigateLastPage": 2,<br>
"lastPage": 2,<br>
"firstPage": 1<br>
},<br>
"success": true<br>
}<br>
- update_shipping_address.do<br>
http://localhost:8080/shipping/update_shipping_address.do<br>
输入<br>
{<br>
  "shippingId":"15",<br>
  "receiverName":"123123",<br>
  "receiverPhone":"",<br>
  "receiverMobile":"???????????",<br>
  "receiverProvince":"广东省",<br>
  "receiverCity":"东莞市",<br>
  "receiverDistrict":"南城区",<br>
  "receiverAddress":"广东科技学院",<br>
  "receiverZip":"523000"<br>
}<br>
输出<br>
{<br>
"status": 1,<br>
"msg": "更新收货地址成功",<br>
"data": null,<br>
"success": true<br>
}<br>

####产品模块
- get_product_list.do<br>
http://localhost:8080/product/get_product_list.do<br>
输入<br>
{
  "pageNum":"1",
  "pageSize":"5"
}
输出<br>
{<br>
"status": 1,<br>
"msg": "查询所有的产品",<br>
"data":{<br>
"pageNum": 1,<br>
"pageSize": 5,<br>
"size": 1,<br>
"startRow": 1,<br>
"endRow": 1,<br>
"total": 1,<br>
"pages": 1,<br>
"list":[<br>
{"id": 11, "categoryId": 100001, "name": "三星 galaxy s7", "subtitle": "s7 edge",…}<br>
],<br>
"prePage": 0,<br>
"nextPage": 0,<br>
"isFirstPage": true,<br>
"isLastPage": true,<br>
"hasPreviousPage": false,<br>
"hasNextPage": false,<br>
"navigatePages": 8,<br>
"navigatepageNums":[<br>
1<br>
],<br>
"navigateFirstPage": 1,<br>
"navigateLastPage": 1,<br>
"firstPage": 1,<br>
"lastPage": 1<br>
},<br>
"success": true<br>
}<br>

#### 订单模块
- create_order.do<br>
http://localhost:8080/order/create_order.do<br>
输入<br>
{<br>
  "shippingId":"13"<br>
}<br>
输出<br>
{<br>
"status": 1,<br>
"msg": "创建订单成功",<br>
"data": null,<br>
"success": true<br>
}<br>
- get_order_list.do<br>
http://localhost:8080/order/get_order_list.do<br>
输入<br>
{
  "pageNum":"2",
  "pageSize":"10"
}
输出<br>
{<br>
"status": 1,<br>
"msg": "查询到该用户的订单",<br>
"data":{<br>
"pageNum": 1,<br>
"pageSize": 10,<br>
"size": 2,<br>
"startRow": 1,<br>
"endRow": 2,<br>
"total": 2,<br>
"pages": 1,<br>
"list":[<br>
{"id": 47, "orderNo": 2018010615311516, "userId": 16, "shippingId": 13, "payment": 109980,…},<br>
{"id": 48, "orderNo": 2018010615315116, "userId": 16, "shippingId": 13, "payment": 5499,…}<br>
],<br>
"prePage": 0,<br>
"nextPage": 0,<br>
"isFirstPage": true,<br>
"isLastPage": true,<br>
"hasPreviousPage": false,<br>
"hasNextPage": false,<br>
"navigatePages": 8,<br>
"navigatepageNums":[<br>
1<br>
],<br>
"navigateFirstPage": 1,<br>
"navigateLastPage": 1,<br>
"firstPage": 1,<br>
"lastPage": 1<br>
},<br>
"success": true<br>
}<br>

#### 购物车
- add_new_product.do<br>
http://localhost:8080/cart/add_new_product.do<br>
输入<br>
{<br>
  "productId":"100001",<br>
  "quantity":"1"<br>
}<br>
输出<br>
{<br>
"status": 1,<br>
"msg": "加入购物车成功",<br>
"data": null,<br>
"success": true<br>
}<br>
- get_cart_list.do<br>
http://localhost:8080/cart/get_cart_list.do<br>
输入<br>
{<br>
  "pageNum":"1",<br>
  "pageSize":"10"<br>
}<br>
输出<br>
{<br>
"status": 1,<br>
"msg": "购物车内的商品",<br>
"data":{<br>
"pageNum": 1,<br>
"pageSize": 10,<br>
"size": 1,<br>
"startRow": 1,<br>
"endRow": 1,<br>
"total": 1,<br>
"pages": 1,<br>
"list":[<br>
{"id": 132, "userId": 16, "productId": 100001, "quantity": 1, "checked": 1,…}<br>
],<br>
"prePage": 0,<br>
"nextPage": 0,<br>
"isFirstPage": true,<br>
"isLastPage": true,<br>
"hasPreviousPage": false,<br>
"hasNextPage": false,<br>
"navigatePages": 8,<br>
"navigatepageNums":[<br>
1<br>
],<br>
"navigateFirstPage": 1,<br>
"navigateLastPage": 1,<br>
"firstPage": 1,<br>
"lastPage": 1<br>
},<br>
"success": true<br>
}<br>
#### 订单详情模块
- get_list.do<br>
http://localhost:8080//order_item/get_list.do<br>
输入<br>
{<br>
  "pageNum":"1",<br>
  "pageSize":"10"<br>
}<br>
输出<br>
{<br>
"status": 1,<br>
"msg": "查询到的订单",<br>
"data":{<br>
"pageNum": 1,<br>
"pageSize": 10,<br>
"size": 6,<br>
"startRow": 1,<br>
"endRow": 6,<br>
"total": 6,<br>
"pages": 1,<br>
"list":[{"id": 1, "userId": 15, "orderNo": 2018010922011915, "productId": 100001, "productName": "三星 galaxy s7",…],<br>
"prePage": 0,<br>
"nextPage": 0,<br>
"isFirstPage": true,<br>
"isLastPage": true,<br>
"hasPreviousPage": false,<br>
"hasNextPage": false,<br>
"navigatePages": 8,<br>
"navigatepageNums":[<br>
1<br>
],<br>
"navigateFirstPage": 1,<br>
"navigateLastPage": 1,<br>
"firstPage": 1,<br>
"lastPage": 1<br>
},<br>
"success": true<br>
}<br>