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
            <form action="SearchStudentServlet" method="get">
                <label for="inputField"></label>
                <input type="text" name="searchText" id="inputField" placeholder="Input text">
                <label for="dropdownMenu"></label>
                <select name="searchOption" id="dropdownMenu">
                    <option value="surname">Surname</option>
                    <option value="name">Name</option>
                    <option value="lastname">Lastname</option>
                    <option value="birthday">Birthday</option>
                    <option value="rank">Rank</option>
                    <option value="email">Email</option>
                    <option value="phone">Phone</option>
                </select>
                <input type="submit" value="Search">
            </form>
            <form action="insertStudent.jsp">
                <button>Insert</button>
            </form>
        </header>
        <table>
            <thead>
            <tr>
                <th>
                    <form action="SortStudentTableServlet" method="get">
                        <input type="submit" name="sort" value="Surname">
                    </form>
                </th>
                <th>
                    <form action="SortStudentTableServlet" method="get">
                        <input type="submit" name="sort" value="Name">
                    </form>
                </th>
                <th>
                    <form action="SortStudentTableServlet" method="get">
                        <input type="submit" name="sort" value="Lastname">
                    </form>
                </th>
                <th>
                    <form action="SortStudentTableServlet" method="get">
                        <input type="submit" name="sort" value="Birthday">
                    </form>
                </th>
                <th>
                    <form action="SortStudentTableServlet" method="get">
                        <input type="submit" name="sort" value="Gender">
                    </form>
                </th>
                <th>
                    <form action="SortStudentTableServlet" method="get">
                        <input type="submit" name="sort" value="Rank">
                    </form>
                </th>

                <th>
                    <form action="SortStudentTableServlet" method="get">
                        <input type="submit" name="sort" value="Contract">
                    </form>
                </th>
                <th>
                    <form action="SortStudentTableServlet" method="get">
                        <input type="submit" name="sort" value="Scholarship">
                    </form>
                </th>
                <th>
                    <form action="SortStudentTableServlet" method="get">
                        <input type="submit" name="sort" value="Email">
                    </form>
                </th>
                <th>
                    <form action="SortStudentTableServlet" method="get">
                        <input type="submit" name="sort" value="Phone">
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
                            <form action="InitStudentServlet" method="get">
                                <input type="hidden" name="id" value="<%= student.getId() %>">
                                <input type="submit" value="Update">
                            </form>
                        </td>
                        <td>
                            <form action="DeleteStudentServlet" method="post">
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
