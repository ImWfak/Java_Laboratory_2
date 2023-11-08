package info.webappborysevychlab_2.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "student_add")
public class StudentAddPart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne
    @JoinColumn(name = "student_main_id")
    private StudentMainPart studentMainPart;
    @Column(name = "contract")
    private Boolean contract;
    @Column(name = "scholarship")
    private Boolean scholarship;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    public StudentAddPart() {}
    public StudentAddPart(StudentMainPart studentMainPart, Boolean contract, Boolean scholarship, String email, String phone) {
        this.studentMainPart = studentMainPart;
        this.contract = contract;
        this.scholarship = scholarship;
        this.email = email;
        this.phone = phone;
    }
    public Long getStudentMainPartId() {return studentMainPart.getId();}
    public StudentMainPart getStudentMainPart() {return studentMainPart;}
    public Boolean getContract() {return contract;}
    public Boolean getScholarship() {return scholarship;}
    public String getEmail() {return email;}
    public String getPhone() {return phone;}
    public void setStudentMainPartId(Long id) {this.studentMainPart.setId(id);}
    public void setStudentMainPart(StudentMainPart studentMainPart) {this.studentMainPart = studentMainPart;}
    public void setContract(Boolean contract) {this.contract = contract;}
    public void setScholarship(Boolean scholarship) {this.scholarship = scholarship;}
    public void setEmail(String email) {this.email = email;}
    public void setPhone(String phone) {this.phone = phone;}
    @Override
    public boolean equals(Object object) {
        StudentAddPart StudentAddPart = (StudentAddPart) object;
        if (this == object)
            return true;
        else if (getClass() != object.getClass())
            return false;
        else if (!StudentAddPart.getStudentMainPart().equals(this.getStudentMainPart()) ||
                !StudentAddPart.getContract().equals(this.getContract()) ||
                !StudentAddPart.getScholarship().equals(this.getScholarship()) ||
                !StudentAddPart.getEmail().equals(this.getEmail()) ||
                !StudentAddPart.getPhone().equals(this.getPhone())) {
            return false;
        }
        return false;
    }
    @Override
    public String toString() {
        return this.getStudentMainPart().toString() + "\n" +
                this.getContract() + "\n" +
                this.getScholarship() + "\n" +
                this.getEmail() + "\n" +
                this.getPhone();
    }
}
