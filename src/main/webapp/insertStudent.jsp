<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/insertStudent.css">
        <script src="js/validateInput.js"></script>
        <title>Insert Student</title>
    </head>
    <body>
        <header>
            <h1>Insert Student</h1>
        </header>
        <form id="mainForm" action="InsertStudentServlet" method="post">

            <label for="surname">Surname:</label>
            <input type="text" name="surname" id="surname" required>

            <label for="name">Name:</label>
            <input type="text" name="name" id="name" required>

            <label for="lastname">Lastname:</label>
            <input type="text" name="lastname" id="lastname" required>

            <label for="birthday">Birthday:</label>
            <input type="date" name="birthday" id="birthday" required>

            <label for="gender">Gender:</label>
            <select name="gender" id="gender">
                <option value="male">Male</option>
                <option value="female">Female</option>
            </select>

            <label for="rank">Rank:</label>
            <input type="text" name="rank" id="rank" required>

            <label for="contract">Contract:</label>
            <input type="checkbox" id="contract">

            <label for="scholarship">Scholarship:</label>
            <input type="checkbox" id="scholarship">

            <label for="email">Email:</label>
            <input type="email" name="email" id="email" required>

            <label for="phone">Phone:</label>
            <input type="tel" name="phone" id="phone" required>

            <input type="submit" value="Insert" onclick="submit()">
        </form>
        <form action="InitStudentTableServlet" method="get">
            <input type="submit" value="Cancel">
        </form>
    </body>
</html>
