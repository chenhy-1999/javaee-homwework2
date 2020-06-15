package class12.servlet;

import class12.jdbc.HomeworkJdbc;
import class12.model.homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


@WebServlet("/postHomework")
public class postHomework extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");//设置编码，以防表单提交的内容乱码

        homework hk = new homework();

        hk.setTitle(req.getParameter("title"));
        hk.setContent(req.getParameter("content"));
        Date date = new Date();
        hk.setCreateTime(date);

        boolean result = HomeworkJdbc.addHomework(hk);

        req.setAttribute("type","postHomework");
        req.getRequestDispatcher("allhomework.jsp").forward(req,resp);
    }
}