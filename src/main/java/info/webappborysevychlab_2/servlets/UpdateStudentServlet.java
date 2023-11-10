package info.webappborysevychlab_2.servlets;

import info.webappborysevychlab_2.dao.StudentDAO;
import info.webappborysevychlab_2.entities.Gender;
import info.webappborysevychlab_2.entities.Student;
import info.webappborysevychlab_2.entities.StudentAddPart;
import info.webappborysevychlab_2.entities.StudentMainPart;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "UpdateStudentServlet", value = "/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StudentMainPart studentMainPart = new StudentMainPart(
                request.getParameter("surname"),
                request.getParameter("name"),
                request.getParameter("lastname"),
                LocalDate.parse(request.getParameter("birthday")),
                Gender.valueOf(request.getParameter("gender")),
                Float.parseFloat(request.getParameter("rank"))
        );
        StudentAddPart studentAddPart = new StudentAddPart(
                studentMainPart,
                Boolean.valueOf(request.getParameter("contract")),
                Boolean.valueOf(request.getParameter("scholarship")),
                request.getParameter("email"),
                request.getParameter("phone")
        );
        Student student = new Student(
                studentMainPart,
                studentAddPart
        );
        Long id = Long.parseLong(request.getParameter("id"));
        new StudentDAO().update(id, student);
        response.sendRedirect(request.getContextPath() + "/InitStudentTableServlet");
    }
}
