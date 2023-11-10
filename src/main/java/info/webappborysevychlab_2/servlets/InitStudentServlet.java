package info.webappborysevychlab_2.servlets;

import info.webappborysevychlab_2.dao.StudentDAO;
import info.webappborysevychlab_2.entities.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InitStudentServlet", value = "/InitStudentServlet")
public class InitStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Student student  = new StudentDAO().findById(id);
        request.setAttribute("student", student);
        request.getServletContext().getRequestDispatcher("/updateStudent.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
