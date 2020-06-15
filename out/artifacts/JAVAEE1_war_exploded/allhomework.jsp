<%@ page import="class12.model.homework" %>
<%@ page import="java.util.List" %>
<%@ page import="class12.jdbc.HomeworkJdbc" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>老师发布的Homework</title>
</head>
<body>

<table align="center" width="960" border="1"
       bgcolor="black" cellpadding="1" cellspacing="1">
    <tr align="center" bgcolor="#7fffd4" height="50">
        <td>ID</td>
        <td>标题</td>
        <td>内容</td>
        <td>创建时间</td>
    </tr>
    <%
        List<homework> list = HomeworkJdbc.selectAll();
        if(null == list || list.size() <= 0){
            out.print("None data.");
        }else {
            for (homework sh : list){
    %>
    <tr align="center" bgcolor="white" height="30">
        <td><%=sh.getId()%></td>
        <td><%=sh.getTitle()%></td>
        <td><%=sh.getContent()%></td>
        <td><%=sh.getCreateTime()%></td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
