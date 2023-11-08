package info.webappborysevychlab_2.entities;

public class Student {
    private StudentMainPart StudentMainPart;
    private StudentAddPart StudentAddPart;
    public Student() {}
    public Student(StudentMainPart studentMainPart, StudentAddPart studentAddPart) {
        this.StudentMainPart = studentMainPart;
        this.StudentAddPart = studentAddPart;
    }
    public Long getId() {return StudentMainPart.getId();}
    public StudentMainPart getStudentMainPart() {return StudentMainPart;}
    public StudentAddPart getStudentAddPart() {return StudentAddPart;}
    public void setId(Long id) {StudentMainPart.setId(id);}
    public void setStudentMainPart(StudentMainPart studentMainPart) {this.StudentMainPart = studentMainPart;}
    public void setStudentAddPart(StudentAddPart studentAddPart) {this.StudentAddPart = studentAddPart;}
    @Override
    public boolean equals(Object object) {
        Student student = (Student) object;
        if (this == object)
            return true;
        else if (getClass() != object.getClass())
            return false;
        else if (!student.getStudentMainPart().equals(this.getStudentMainPart()) ||
                !student.getStudentAddPart().equals(this.getStudentAddPart())) {
            return false;
        }
        return false;
    }
    @Override
    public String toString() {
        return this.getStudentMainPart().toString() + "\n" +
                this.getStudentAddPart().toString();
    }
}
