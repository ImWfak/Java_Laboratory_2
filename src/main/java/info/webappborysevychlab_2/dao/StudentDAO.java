package info.webappborysevychlab_2.dao;

import info.webappborysevychlab_2.entities.Student;
import info.webappborysevychlab_2.entities.StudentAddPart;
import info.webappborysevychlab_2.entities.StudentMainPart;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements InterfaceDAO<Student> {
    @Override
    public List<Student> getAllList() {
        List<StudentMainPart> StudentMainPartList = new StudentMainPartDAO().getAllList();
        List<StudentAddPart> StudentAddPartList = new StudentAddPartDAO().getAllList();
        List<Student> studentList = new ArrayList<>();
        for (int index = 0; index < StudentMainPartList.size() || index < StudentAddPartList.size(); index++) {
            studentList.add(new Student(
                    StudentMainPartList.get(index),
                    StudentAddPartList.get(index)
            ));
        }
        return studentList;
    }
    @Override
    public Student findById(Long id) {
        return new Student(
                new StudentMainPartDAO().findById(id),
                new StudentAddPartDAO().findById(id)
        );
    }
    @Override
    public boolean insert(Student studentToInsert) {
        boolean resultMain = new StudentMainPartDAO().insert(studentToInsert.getStudentMainPart());
        boolean resultAdd = new StudentAddPartDAO().insert(studentToInsert.getStudentAddPart());
        return resultMain && resultAdd;
    }
    @Override
    public boolean update(Long idOfUpdatableRow, Student studentToUpdate) {
        boolean resultAdd = new StudentAddPartDAO().update(idOfUpdatableRow, studentToUpdate.getStudentAddPart());
        boolean resultMain = new StudentMainPartDAO().update(idOfUpdatableRow, studentToUpdate.getStudentMainPart());
        return resultMain && resultAdd;
    }
    @Override
    public boolean delete(Student studentToDelete) {
        boolean resultAdd = new StudentAddPartDAO().delete(studentToDelete.getStudentAddPart());
        boolean resultMain = new StudentMainPartDAO().delete(studentToDelete.getStudentMainPart());
        return resultMain && resultAdd;
    }
}
