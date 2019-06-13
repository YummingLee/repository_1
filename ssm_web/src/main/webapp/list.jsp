<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.3.1.js"></script>
    <script src="js/getParameter.js"></script>
    <script>
        $(function () {

            $.post("/account/findAll",{},function (data) {
                var div = '    <tr>\n' +
                    '        <th>编号</th>\n' +
                    '        <th>姓名</th>\n' +
                    '        <th>金额</th>\n' +
                    '        <th colspan="2">选项</th>\n' +
                    '    </tr>';
                $.each($.parseJSON(data),function (index) {

                    div += '    <tr>\n' +
                        '        <td align="center">'+(index+1)+'</td>\n' +
                        '        <td align="center">'+this.name+'</td>\n' +
                        '        <td align="right">'+this.money+'</td>\n' +
                        '        <td>\n' +
                        '            <input type="button" value="修改"  onclick="updateUser('+this.id+')"/>\n' +
                        '            <input type="button" value="删除"  onclick="deleteById('+this.id+')"/>\n' +
                        '        </td>\n' +
                        '    </tr>'

                });

                $("#UserMessage").html(div)
            })

        });

        function updateUser(id) {
            $.get("/account/findOne",{id:id},function () {
                location.href="update.jsp?id="+id
            })
        }

        function deleteById(id) {

            $.post("/account/delete",{id:id},function () {
                    location.href="list.jsp"
            })
        }

    </script>
</head>
<body>


   <a href="save.jsp">添加新用户</a>


<table id="UserMessage" border="1" >
    <%--<tr>--%>
        <%--<th>编号</th>--%>
        <%--<th>姓名</th>--%>
        <%--<th>金额</th>--%>
        <%--<th colspan="2">选项</th>--%>
    <%--</tr>--%>
    <%--<tr>--%>
        <%--<td></td>--%>
        <%--<td></td>--%>
        <%--<td></td>--%>
        <%--<td>--%>
            <%--<a href="#">修改</a>--%>
            <%--<a href="#" >删除</a>--%>
        <%--</td>--%>
    <%--</tr>--%>
</table>

</body>
</html>
