<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2020/3/9
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
</head>
<body>
<div align="center">
    <h2>添加学生</h2>
    <form action="${pageContext.request.contextPath}/addstudent" method="post">
        <table style="line-height: 40px">
            <tr>
                <th>学号:</th>
                <td><input type="text" name="id" maxlength="30" size="50" required></td>
            </tr>
            <tr>
                <th>姓名:</th>
                <td><input type="text" name="name" maxlength="30" size="50" required></td>
            </tr>

            <tr align="center">
                <td><input type="submit" value="添加学生"> </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
