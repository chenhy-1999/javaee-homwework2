<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布作业</title>
</head>
<body>
<div align="center">
    <h2>发布作业</h2>
    <form action="${pageContext.request.contextPath}/postHomework" method="post">
        <table style="line-height: 40px">
            <tr>
                <th>作业标题:</th>
                <td><input type="text" name="title" maxlength="30" size="50" required></td>
            </tr>
            <tr>
                <th>作业内容:</th>
                <td><input type="text" name="content" maxlength="30" size="50" required></td>
            </tr>

            <tr align="center">
                <td><input type="submit" value="添加作业"> </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
