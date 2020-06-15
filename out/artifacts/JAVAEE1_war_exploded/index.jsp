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
    <title>My Homework</title>
  </head>
  <body>

  <table align="center" width="960" border="1"
         bgcolor="black" cellpadding="1" cellspacing="1">
    <tr align="center" bgcolor="#7fffd4" height="50">
      <td>ID</td>
      <td>学生学号</td>
      <td>作业编号</td>
      <td>作业标题</td>
      <td>作业内容</td>
      <td>创建时间</td>
    </tr>
    <%
      List<StudentHomework> list = StudentHomeworkJdbc.selectAll();
      if(null == list || list.size() <= 0){
        out.print("None data.");
      }else {
        for (StudentHomework sh : list){
    %>
    <tr align="center" bgcolor="white" height="30">
      <td><%=sh.getId()%></td>
      <td><%=sh.getStudentId()%></td>
      <td><%=sh.getHomeworkId()%></td>
      <td><%=sh.getHomeworkTitle()%></td>
      <td><%=sh.getHomeworkContent()%></td>
      <td><%=sh.getCreateTime()%></td>
    </tr>
    <%
        }
      }
    %>
  </table>
  </body>
</html>
