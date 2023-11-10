<%@ page import="info.webappborysevychlab_2.entities.Student" %>
<%@ page import="info.webappborysevychlab_2.entities.StudentAddPart" %>
<%@ page import="info.webappborysevychlab_2.entities.StudentMainPart" %>
<%@ page import="info.webappborysevychlab_2.entities.Gender" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/updateStudent.css">
        <script src="js/validateInput.js"></script>
        <title>Update Student</title>
    </head>
    <body>
        <header>
            <h1>Update Student</h1>
        </header>
        <form id="mainForm" action="UpdateStudentServlet" method="post">
            <%
                Student student = (Student) request.getAttribute("student");
                StudentMainPart studentMainPart = student.getStudentMainPart();
                StudentAddPart studentAddPart = student.getStudentAddPart();
            %>
            <input type="hidden" name="id" value="<%= student.getId() %>">

            <label for="surname">Surname:</label>
            <input type="text" name="surname" id="surname" value="<%= studentMainPart.getSurname() %>" required>

            <label for="name">Name:</label>
            <input type="text" name="name" id="name" value="<%= studentMainPart.getName() %>" required>

            <label for="lastname">Lastname:</label>
            <input type="text" name="lastname" id="lastname" value="<%= studentMainPart.getLastname() %>" required>

            <label for="birthday">Birthday:</label>
            <input type="date" name="birthday" id="birthday" value="<%= studentMainPart.getBirthday() %>" required>

            <label for="gender">Gender:</label>
            <select name="gender" id="gender">
                <option value="male" <%= studentMainPart.getGender().equals(Gender.male) ? "selected" : "" %>>Male</option>
                <option value="female" <%= studentMainPart.getGender().equals(Gender.female) ? "selected" : "" %>>Female</option>
            </select>

            <label for="rank">Rank:</label>
            <input type="text" name="rank" id="rank" value="<%= studentMainPart.getRank() %>" required>

            <label for="contract">Contract:</label>
            <input type="checkbox" id="contract" <%= studentAddPart.getContract() ? "checked" : "" %>>

            <label for="scholarship">Scholarship:</label>
            <input type="checkbox" id="scholarship" <%= studentAddPart.getScholarship() ? "checked" : "" %>>

            <label for="email">Email:</label>
            <input type="email" name="email" id="email" value="<%= studentAddPart.getEmail() %>" required>

            <label for="phone">Phone:</label>
            <input type="tel" name="phone" id="phone" value="<%= studentAddPart.getPhone() %>" required>

            <input type="submit" value="Update" onclick="submit()">
        </form>
        <form action="InitStudentTableServlet" method="get">
            <input type="submit" value="Cancel">
        </form>
    </body>
</html>
