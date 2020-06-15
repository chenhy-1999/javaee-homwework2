package class12.servlet;

import class12.jdbc.HomeworkJdbc;
import class12.jdbc.StudentJdbc;
import class12.model.student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


@WebServlet("/addstudent")
public class addstudent extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");//设置编码，以防表单提交的内容乱码

        student st = new student();

        st.setId(req.getParameter("id"));
        st.setName(req.getParameter("name"));
        Date date = new Date();
        st.setCreateTime(date);

        boolean result = StudentJdbc.addstudent(st);

        req.getRequestDispatcher("allstudent.jsp").forward(req,resp);
    }
}