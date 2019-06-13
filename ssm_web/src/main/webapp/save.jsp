<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.3.1.js"></script>
    <script src="js/getParameter.js"></script>
</head>
<body>
<form action="/account/save" method="post" >
  姓名  <input type="text" name="name"> <br>
  金额  <input type="text" name="money"> <br>
    <input type="submit" value="提交">

</form>
</body>
</html>
