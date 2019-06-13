<%--
  Created by IntelliJ IDEA.
  User: 12004
  Date: 2019/6/8
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/test6" method="post" enctype="multipart/form-data">
    名称<input type="text" name="username"><br/>
    文件<input type="file" name="uploadFile"><br/>
    文件<input type="file" name="uploadFile"><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
