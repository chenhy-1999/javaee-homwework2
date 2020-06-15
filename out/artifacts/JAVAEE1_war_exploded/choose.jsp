<%@ page import="class12.model.StudentHomework" %>
<%@ page import="java.util.List" %>
<%@ page import="class12.jdbc.StudentHomeworkJdbc" %>

<%--
  Created by IntelliJ IDEA.
  User: wkm
  Date: 2020/2/27
  Time: 09:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>choose what you want to do</title>
</head>
<body>

<table align="center" width="960" border="1"
       bgcolor="black" cellpadding="1" cellspacing="1">
    <tr align="center" bgcolor="#5f9ea0" height="50">
        <td>学生</td>
        <td>老师</td>
    </tr>
    <tr align="center" bgcolor="white" height="30">
        <td><a href="allhomework.jsp">查看老师发布的作业</a></td>
        <td><a href="addstudent.jsp">添加学生</a></td>
    </tr>
    <tr align="center" bgcolor="white" height="30">
        <td><a href="addhomework.jsp">提交作业</a></td>
        <td><a href="post_homework.jsp">发布作业</a></td>
    </tr>

</table>

<h2 align="center" bgcolor="white" height="30"><a href="index.jsp">查看作业完成情况</a></h2>
</body>
</html>
