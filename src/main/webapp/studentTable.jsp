<%@ page import="info.webappborysevychlab_2.dao.StudentDAO" %>
<%@ page import="info.webappborysevychlab_2.entities.Student" %>
<%@ page import="info.webappborysevychlab_2.entities.StudentAddPart" %>
<%@ page import="info.webappborysevychlab_2.entities.StudentMainPart" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Student Table</title>
    </head>
    <body>
        <header>
            <label for="inputField"></label>
            <input type="text" id="inputField" placeholder="Enter text">
            <label for="dropdownMenu"></label>
            <select id="dropdownMenu">
                <option value="Surname" name="method">Surname</option>
                <option value="Name" name="method">Name</option>
                <option value="Lastname" name="method">Lastname</option>
                <option value="Birthday" name="method">Birthday</option>
                <option value="Gender" name="method">Gender</option>
                <option value="Rank" name="method">Rank</option>
                <option value="Contract" name="method">Contract</option>
                <option value="Scholarship" name="method">Scholarship</option>
                <option value="Email" name="method">Email</option>
                <option value="Phone" name="method">Phone</option>
            </select>
            <form action="insertStudent.jsp">
                <button>Insert</button>
            </form>
        </header>
        <table>
            <thead>
            <tr>
                <th>
                    <form action="SortStudentTableServlet" method="get">
                        <input type="submit" name="method" value="Surname">
                    </form>
                </th>
                <th>
                    <form action="SortStudentTableServlet" method="get">
                        <input type="submit" name="method" value="Name">
                    </form>
                </th>
                <th>
                    <form action="SortStudentTableServlet" method="get">
                        <input type="submit" name="method" value="Lastname">
                    </form>
                </th>
                <th>
                    <form action="SortStudentTableServlet" method="get">
                        <input type="submit" name="method" value="Birthday">
                    </form>
                </th>
                <th>
                    <form action="SortStudentTableServlet" method="get">
                        <input type="submit" name="method" value="Gender">
                    </form>
                </th>
                <th>
                    <form action="SortStudentTableServlet" method="get">
                        <input type="submit" name="method" value="Rank">
                    </form>
                </th>

                <th>
                    <form action="SortStudentTableServlet" method="get">
                        <input type="submit" name="method" value="Contract">
                    </form>
                </th>
                <th>
                    <form action="SortStudentTableServlet" method="get">
                        <input type="submit" name="method" value="Scholarship">
                    </form>
                </th>
                <th>
                    <form action="SortStudentTableServlet" method="get">
                        <input type="submit" name="method" value="Email">
                    </form>
                </th>
                <th>
                    <form action="SortStudentTableServlet" method="get">
                        <input type="submit" name="method" value="Phone">
                    </form>
                </th>

                <th class="functions" colspan="2">Functions</th>
            </tr>
            </thead>
            <tbody>
                <%
                    List<Student> studentList = (List<Student>) request.getAttribute("studentList");
                    for (Student student : studentList) {
                %>
                    <tr>
                        <%
                            StudentMainPart studentMainPart = student.getStudentMainPart();
                            StudentAddPart studentAddPart = student.getStudentAddPart();
                        %>
                        <td> <%= studentMainPart.getSurname() %> </td>
                        <td> <%= studentMainPart.getName() %> </td>
                        <td> <%= studentMainPart.getLastname() %> </td>
                        <td> <%= studentMainPart.getBirthday() %> </td>
                        <td> <%= studentMainPart.getGender() %> </td>
                        <td> <%= studentMainPart.getRank() %> </td>
                        <td> <%= studentAddPart.getContract() %> </td>
                        <td> <%= studentAddPart.getScholarship() %> </td>
                        <td> <%= studentAddPart.getEmail() %> </td>
                        <td> <%= studentAddPart.getPhone() %> </td>
                        <td>
                            <form action="UpdateStudentServlet">
                                <input type="submit" value="Update">
                            </form>
                        </td>
                        <td>
                            <form action="DeleteStudentServlet">
                                <input type="submit" value="Delete">
                            </form>
                        </td>
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
