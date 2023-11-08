package info.webappborysevychlab_2.servlets;

import info.webappborysevychlab_2.dao.StudentDAO;
import info.webappborysevychlab_2.entities.Student;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "InitStudentTableServlet", value = "/InitStudentTableServlet")
public class InitStudentTableServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Student> studentList = new StudentDAO().getAllList();
        request.setAttribute("studentList", studentList);
        response.sendRedirect(getServletContext() + "/studentTable.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}
