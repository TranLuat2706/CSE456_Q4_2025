package vn.edu.eiu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tbl_Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StudentID", columnDefinition = "BIGINT")
    private long id;

    @Column(name = "FullName", columnDefinition = "NVARCHAR(100)", nullable = false)
    private String fullName;

    @Column(name = "Gender", nullable = false)
    private Gender gender;

    @Column(name = "Dob", nullable = false)
    private LocalDate dob;

    @Column(name = "GPA")
    private double gpa;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "MajorId")
    private Major major;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "SchoolID")
    private School school;

    @Column(name = "EnrollmentYear", columnDefinition = "INT", nullable = false)
    private int enrollmentYear;

    //tự thêm 1 constructor đầy đủ tham số và bỏ id, vì nó sinh ra tự động. Major sẽ được add vào sau
    public Student(String fullName, Gender gender, LocalDate dob, double gpa, int enrollmentYear) {
        this.fullName = fullName;
        this.gender = gender;
        this.dob = dob;
        this.gpa = gpa;
        this.enrollmentYear = enrollmentYear;
    }
}