<!DOCTYPE html>
<html>
    <head>
        <title>Insert Student</title>
    </head>
    <body>
        <header>
            <h1>Insert Student</h1>
        </header>
        <form action="InsertStudentServlet" method="post">
            <label for="lastname">Lastname:</label>
            <input type="text" name="lastname" id="lastname" required><br>

            <label for="name">Name:</label>
            <input type="text" name="name" id="name" required><br>

            <label for="surname">Surname:</label>
            <input type="text" name="surname" id="surname" required><br>

            <label for="birthday">Birthday:</label>
            <input type="date" name="birthday" id="birthday" required><br>

            <label for="gender">Gender:</label>
            <input type="text" name="gender" id="gender" required><br>

            <label for="rank">Rank:</label>
            <input type="text" name="rank" id="rank" required><br>

            <label for="contract">Contract:</label>
            <input type="text" name="contract" id="contract" required><br>

            <label for="scholarship">Scholarship:</label>
            <input type="text" name="scholarship" id="scholarship" required><br>

            <label for="email">Email:</label>
            <input type="email" name="email" id="email" required><br>

            <label for="phone">Phone:</label>
            <input type="tel" name="phone" id="phone" required><br>

            <input type="submit" value="Insert" onclick="">
        </form>
        <form action="InitStudentTableServlet">
            <input type="submit" value="Cancel">
        </form>
    </body>
</html>
