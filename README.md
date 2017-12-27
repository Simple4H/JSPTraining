# JSPTraining
_User Module_
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
"msg": "邮箱已经存在",<br><br>
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
