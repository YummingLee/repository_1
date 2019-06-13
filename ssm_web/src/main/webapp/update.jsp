<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.3.1.js"></script>
    <script src="js/getParameter.js"></script>
    <script>


    </script>
</head>
<body>

<form action="/account/update" method="post">
    <table>
                <input type="hidden"  name="id" value="${account.id}">
        姓名  <input type="text" name="name" value="${account.name}">
        金额  <input type="text" name="money" value="${account.money}">
        <input type="submit" value="提交">
    </table>
</form>




</body>
</html>
