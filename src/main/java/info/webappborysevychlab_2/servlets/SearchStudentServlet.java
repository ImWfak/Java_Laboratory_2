package info.webappborysevychlab_2.servlets;

import info.webappborysevychlab_2.dao.StudentDAO;
import info.webappborysevychlab_2.entities.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchStudentServlet", value = "/SearchStudentServlet")
public class SearchStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = new StudentDAO().getAllList();
        List<Student> resultStudentList = new ArrayList<>();
        String searchText = request.getParameter("searchText");
        String searchOption = request.getParameter("searchOption");
        switch (searchOption) {
            case "surname" -> {
                for (Student student : studentList)
                    if (student.getStudentMainPart().getSurname().contains(searchText))
                        resultStudentList.add(student);
            }
            case "name" -> {
                for (Student student : studentList)
                    if (student.getStudentMainPart().getName().contains(searchText))
                        resultStudentList.add(student);
            }
            case "lastname" -> {
                for (Student student : studentList)
                    if (student.getStudentMainPart().getLastname().contains(searchText))
                        resultStudentList.add(student);
            }
            case "birthday" -> {
                for (Student student: studentList)
                    if (student.getStudentMainPart().getBirthday().toString().contains(searchText))
                        resultStudentList.add(student);
            }
            case "rank" -> {
                for (Student student : studentList)
                    if (student.getStudentMainPart().getRank().toString().contains(searchText))
                        resultStudentList.add(student);
            }
            case "email" -> {
                for (Student student : studentList)
                    if (student.getStudentAddPart().getEmail().contains(searchText))
                        resultStudentList.add(student);
            }
            case "phone" -> {
                for (Student student : studentList)
                    if (student.getStudentAddPart().getPhone().contains(searchText))
                        resultStudentList.add(student);
            }
            default -> throw new IllegalStateException("Unexpected value: " + searchOption);
        }
        request.setAttribute("studentList", resultStudentList);
        request.getServletContext().getRequestDispatcher("/studentTable.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
