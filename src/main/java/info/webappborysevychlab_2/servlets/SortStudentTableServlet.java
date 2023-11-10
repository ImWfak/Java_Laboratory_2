package info.webappborysevychlab_2.servlets;

import info.webappborysevychlab_2.dao.StudentDAO;
import info.webappborysevychlab_2.entities.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Comparator;

@WebServlet(name = "SortStudentTableServlet", value = "/SortStudentTableServlet")
public class SortStudentTableServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = new StudentDAO().getAllList();
        String method = request.getParameter("method");
        switch (method) {
            case "Surname" -> studentList.sort(
                    (firstStudent, secondStudent) -> firstStudent.getStudentMainPart().getSurname().compareToIgnoreCase(secondStudent.getStudentMainPart().getSurname())
            );
            case "Name" -> studentList.sort(
                    (firstStudent, secondStudent) -> firstStudent.getStudentMainPart().getName().compareToIgnoreCase(secondStudent.getStudentMainPart().getName())
            );
            case "Lastname" -> studentList.sort(
                    (firstStudent, secondStudent) -> firstStudent.getStudentMainPart().getLastname().compareToIgnoreCase(secondStudent.getStudentMainPart().getLastname())
            );
            case "Birthday" -> studentList.sort(
                    Comparator.comparing(firstStudent -> firstStudent.getStudentMainPart().getBirthday())
            );
            case "Gender" -> studentList.sort(
                    (firstStudent, secondStudent) -> firstStudent.getStudentMainPart().getGender().toString().compareToIgnoreCase(secondStudent.getStudentMainPart().toString())
            );
            case "Rank" -> studentList.sort(
                    (firstStudent, secondStudent) -> Float.compare(firstStudent.getStudentMainPart().getRank(), secondStudent.getStudentMainPart().getRank())
            );
            case "Contract" -> studentList.sort(
                    (firstStudent, secondStudent) -> Boolean.compare(firstStudent.getStudentAddPart().getContract(), secondStudent.getStudentAddPart().getContract())
            );
            case "Scholarship" -> studentList.sort(
                    (firstStudent, secondStudent) -> Boolean.compare(firstStudent.getStudentAddPart().getScholarship(), secondStudent.getStudentAddPart().getScholarship())
            );
            case "Email" -> studentList.sort(
                    (firstStudent, secondStudent) -> firstStudent.getStudentAddPart().getEmail().compareToIgnoreCase(secondStudent.getStudentAddPart().getEmail())
            );
            case "Phone" -> studentList.sort(
                    (firstStudent, secondStudent) -> firstStudent.getStudentAddPart().getPhone().compareToIgnoreCase(secondStudent.getStudentAddPart().getPhone())
            );
            default -> throw new IllegalStateException("Unexpected value: " + method);
        }
        request.setAttribute("studentList", studentList);
        request.getServletContext().getRequestDispatcher("/studentTable.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
