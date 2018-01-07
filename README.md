# JSPTraining
**_User Module_**
<br>
- login.do<br>
输出<br>
{<br>
  "username": "simple",<br>
  "password": "123123123"<br>
}<br>
输出<br>
{<br>
"status": 0,<br>
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
"status": 0,<br>
"msg": "注册成功",<br>
"data": null,<br>
"success": true<br>
}<br>
- update_user_email.do<br>
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
输入 <br>
{<br>
  "phone":"???????????"<br>
}<br>
输出<br>
{<br>
"status": 0,<br>
"msg": "修改手机号码成功",<br>
"data": null,<br>
"success": true<br>
}<br>
- update_user_password.do<br>
输入<br>
{<br>
  "oldPassword":"123123123",<br>
  "newPassword":"asdasdasd"<br>
}<br>
输出<br>
{<br>
"status": 0,<br>
"msg": "修改密码成功",<br>
"data": null,<br>
"success": true<br>
}<br>
- forget_password_check_answer.do<br>
输入<br>
{<br>
  "username":"huangbude",<br>
  "question":"好不好",<br>
  "answer":"好"<br>
}<br>
输出<br>
{<br>
"status": 0,<br>
"msg": "获取token成功",<br>
"data": "583c72ff-7adf-4e5c-8bfe-4f539f4d7a62",<br>
"success": true<br>
}<br>
- reset_password.do<br>
输入<br>
{<br>
  "username":"huangbude",<br>
  "newPassword":"123123123",<br>
  "forgetToken":"583c72ff-7adf-4e5c-8bfe-4f539f4d7a62"<br>
}<br>
输出<br>
{<br>
"status": 0,<br>
"msg": "修改密码成功",<br>
"data": null,<br>
"success": true<br>
}<br>
- logout.do<br>
输入<br>
{<br>
}<br>
输出<br>
{<br>
"status": 0,<br>
"msg": "登出成功",<br>
"data": null,<br>
"success": true<br>
}<br>
- get_user_information.do<br>
输入<br>
{<br>
}<br>
输出<br>
{<br>
"status": 0,<br>
"msg": "查询成功",<br>
"data":{<br>
"id": 15,<br>
"username": "simple",<br>
"password": "",<br>
"email": "crescentcxm@gmail.com",<br>
"phone": "18578230461",<br>
"question": "没有bug",<br>
"answer": "是的",<br>
"role": 1,<br>
"createTime": 1514298249000,<br>
"updateTime": 1514298249000<br>
},<br>
"success": true<br>
}<br>
- update_question_and_answer.do<br>
输入<br>
{<br>
  "question":"没有bug",<br>
  "answer":"是的"<br>
}<br>
输出<br>
{<br>
"status": 0,<br>
"msg": "修改问题和答案成功",<br>
"data": null,<br>
"success": true<br>
}<br>

**_Shipping Module_**
- add_shipping_address.do<br>
输入<br>
{<br>
  "receiverName":"huangbude",<br>
  "receiverPhone":"",<br>
  "receiverMobile":"18578230461",<br>
  "receiverProvince":"广东省",<br>
  "receiverCity":"东莞市",<br>
  "receiverDistrict":"南城区",<br>
  "receiverAddress":"广东科技学院",<br>
  "receiverZip":"523000"<br>
}<br>
输出<br>
{<br>
"status": 0,<br>
"msg": "新建收货地址成功",<br>
"data": null,<br>
"success": true<br>
}<br>
- delete_shipping_address.do<br>
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
输入<br>
{<br>
  "pageNum":"1",<br>
  "pageSize":"5"<br>
}<br>
输出<br>
{<br>
"status": 0,<br>
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
输入<br>
{<br>
  "shippingId":"15",<br>
  "receiverName":"123123",<br>
  "receiverPhone":"",<br>
  "receiverMobile":"18578230461",<br>
  "receiverProvince":"广东省",<br>
  "receiverCity":"东莞市",<br>
  "receiverDistrict":"南城区",<br>
  "receiverAddress":"广东科技学院",<br>
  "receiverZip":"523000"<br>
}<br>
输出<br>
{<br>
"status": 0,<br>
"msg": "更新收货地址成功",<br>
"data": null,<br>
"success": true<br>
}<br>

**_Product Module_**
- get_product_list.do<br>
输入<br>
{
  "pageNum":"1",
  "pageSize":"5"
}
输出<br>
{<br>
"status": 0,<br>
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

**_Order Module_**
- create_order.do<br>
输入<br>
{<br>
  "shippingId":"13"<br>
}<br>
输出<br>
{<br>
"status": 0,<br>
"msg": "创建订单成功",<br>
"data": null,<br>
"success": true<br>
}<br>
- get_order_list.do<br>
输入<br>
{
  "pageNum":"2",
  "pageSize":"10"
}
输出<br>
{<br>
"status": 0,<br>
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

**_Cart Module_**
- add_new_product.do<br>
输入<br>
{<br>
  "productId":"100001",<br>
  "quantity":"1"<br>
}<br>
输出<br>
{<br>
"status": 0,<br>
"msg": "加入购物车成功",<br>
"data": null,<br>
"success": true<br>
}<br>
- get_cart_list.do<br>
输入<br>
{<br>
  "pageNum":"1",<br>
  "pageSize":"10"<br>
}<br>
输出<br>
{<br>
"status": 0,<br>
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
