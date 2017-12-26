# JSPTraining
##user module
register.do <br>
输入的字段<br>
{<br>
  "username": "huangbude",<br>
  "password": "123123123",<br>
  "email":"crescentcxm@gmail.com",<br>
  "phone":"18578230461",<br>
  "question":"没有bug",<br>
  "answer":"是的"<br>
}
<br>
返回值<br>
{<br>
"status": 0,<br>
"msg": "SUCCESS",<br>
"data": null,<br>
"success": true<br>
}<br>
<br><br>
login.do <br>
输入的字段<br>
{<br>
  "username": "huangbude",<br>
  "password": "123123123"<br>
}<br>
返回值<br>
{<br>
   "status": 0,<br>
   "msg": "SUCCESS",<br>
   "data":{<br>
   "id": 12,<br>
   "username": "huangbude",<br>
   "password": "123123123",<br>
   "email": "没有bug",<br>
   "phone": "是的",<br>
   "question": "???????????",<br>
   "answer": "crescentcxm@gmail.com",<br>
   "role": 0,<br>
   "createTime": 1514294340000,<br>
   "updateTime": 1514294340000<br>
   },<br>
   "success": true<br>
   }<br>
<br><br>
