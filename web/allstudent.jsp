<%@ page import="class12.model.student" %>
<%@ page import="java.util.List" %>
<%@ page import="class12.jdbc.StudentJdbc" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有学生</title>
</head>
<body>

<table align="center" width="960" border="1"
       bgcolor="black" cellpadding="1" cellspacing="1">
    <tr align="center" bgcolor="#7fffd4" height="50">
        <td>ID</td>
        <td>姓名</td>
        <td>创建时间</td>
    </tr>
    <%
        List<student> list = StudentJdbc.selectAll();
        if(null == list || list.size() <= 0){
            out.print("None data.");
        }else {
            for (student sh : list){
    %>
    <tr align="center" bgcolor="white" height="30">
        <td><%=sh.getId()%></td>
        <td><%=sh.getName()%></td>
        <td><%=sh.getCreateTime()%></td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
