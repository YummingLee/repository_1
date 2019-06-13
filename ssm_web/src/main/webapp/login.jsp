<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.3.1.js"></script>
    <script src="js/getParameter.js"></script>
</head>
<body>
<form action="/user/login"  method="post">

    <table>
        <tr>
            <td>用户名:<input type="text" name="username"></td>
            <td>密码:<input type="password" name="password"></td>
            <td><input type="submit" value="登陆"></td>
            <td> <font color="#ff1493" size="1">${msg}</font></td>
        </tr>
    </table>




</form>
</body>
</html>
