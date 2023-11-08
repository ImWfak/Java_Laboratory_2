package info.webappborysevychlab_2.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "student_main")
public class StudentMainPart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "surname")
    private String surname;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "birthday")
    private LocalDate birthday;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;
    @Column(name = "rank")
    private Float rank;
    public StudentMainPart() {}
    public StudentMainPart(String surname, String name, String lastname, LocalDate birthday, Gender gender, Float rank) {
        this.surname = surname;
        this.name = name;
        this.lastname = lastname;
        this.birthday = birthday;
        this.gender = gender;
        this.rank = rank;
    }
    public Long getId() {return id;}
    public String getSurname() {return surname;}
    public String getName() {return name;}
    public String getLastname() {return lastname;}
    public LocalDate getBirthday() {return birthday;}
    public Gender getGender() {return gender;}
    public Float getRank() {return rank;}
    public void setId(Long id) {this.id = id;}
    public void setSurname(String surname) {this.surname = surname;}
    public void setName(String name) {this.name = name;}
    public void setLastname(String lastname) {this.lastname = lastname;}
    public void setBirthday(LocalDate birthday) {this.birthday = birthday;}
    public void setGender(Gender gender) {this.gender = gender;}
    public void setRank(Float rank) {this.rank = rank;}
    @Override
    public boolean equals(Object object) {
        StudentMainPart studentMainPart = (StudentMainPart) object;
        if (this == object)
            return true;
        else if (getClass() != object.getClass())
            return false;
        else if (!studentMainPart.getSurname().equals(this.getSurname()) ||
                !studentMainPart.getName().equals(this.getName()) ||
                !studentMainPart.getLastname().equals(this.getLastname()) ||
                !studentMainPart.getBirthday().equals(this.getBirthday()) ||
                !studentMainPart.getGender().equals(this.getGender()) ||
                !studentMainPart.getRank().equals(this.getRank())) {
            return false;
        }
        return false;
    }
    @Override
    public String toString() {
        return this.getSurname() + "\n" +
                this.getName() + "\n" +
                this.getLastname() + "\n" +
                this.getBirthday() + "\n" +
                this.getGender() + "\n" +
                this.getRank();
    }
}
