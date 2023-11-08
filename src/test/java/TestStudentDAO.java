import info.webappborysevychlab_2.dao.StudentDAO;
import info.webappborysevychlab_2.entities.Gender;
import info.webappborysevychlab_2.entities.Student;
import info.webappborysevychlab_2.entities.StudentAddPart;
import info.webappborysevychlab_2.entities.StudentMainPart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class TestStudentDAO {
    private static final StudentMainPart firsStudentMainPart;
    private static final StudentAddPart firstStudentAddPart;
    private static final Student firstStudent;
    private static final StudentMainPart secondStudentMainPart;
    private static final StudentAddPart secondStudentAddPart;
    private static final Student secondStudent;
    private static final StudentMainPart thirdStudentMainPart;
    private static final StudentAddPart thirdStudentAddPart;
    private static final Student thirdStudent;
    static {
        firsStudentMainPart = new StudentMainPart(
                "Borysevych",
                "Alex",
                "Sergeevich",
                LocalDate.now(),
                Gender.male,
                170.F
        );
        firstStudentAddPart = new StudentAddPart(
                firsStudentMainPart,
                true,
                false,
                "borusovaleks@gmail.com",
                "+380500605816"
        );
        firstStudent = new Student(
                firsStudentMainPart,
                firstStudentAddPart
        );
        secondStudentMainPart = new StudentMainPart(
                "Vishnevskiy",
                "Kolya",
                "Nikolayevich",
                LocalDate.now(),
                Gender.male,
                170.F
        );
        secondStudentAddPart = new StudentAddPart(
                secondStudentMainPart,
                true,
                false,
                "vishnevskiykoly@gmail.com",
                "+380148819840"
        );
        secondStudent = new Student(
                secondStudentMainPart,
                secondStudentAddPart
        );
        thirdStudentMainPart = new StudentMainPart(
                "Lipovetskiy",
                "Seva",
                "Aleksandrov",
                LocalDate.now(),
                Gender.male,
                190.F
        );
        thirdStudentAddPart = new StudentAddPart(
                thirdStudentMainPart,
                false,
                true,
                "seva@gmail.com",
                "+380555555555"
        );
        thirdStudent = new Student(
                thirdStudentMainPart,
                thirdStudentAddPart
        );
    }
    private static void resetTables() {
        StudentDAO studentDAO = new StudentDAO();
        for (Student student : studentDAO.getAllList())
            studentDAO.delete(student);
    }
    @Test
    public void testInsert() {
        boolean result = new StudentDAO().insert(firstStudent);
        if (!result)
            Assertions.fail();
        resetTables();
    }
    @Test
    public void testUpdate() {
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.insert(firstStudent);
        boolean result = studentDAO.update(
                firstStudent.getId(),
                secondStudent
        );
        if (!result)
            Assertions.fail();
        resetTables();
    }
    @Test
    public void testDelete() {
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.insert(firstStudent);
        boolean result = studentDAO.delete(firstStudent);
        if (!result)
            Assertions.fail();
        resetTables();
    }
}
