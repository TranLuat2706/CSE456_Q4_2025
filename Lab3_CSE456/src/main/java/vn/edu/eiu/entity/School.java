package vn.edu.eiu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tbl_School")
public class School {
    @Id
    @Column(name = "SchoolID", columnDefinition = "CHAR(3)")
    private String schoolId;

    @Column(name = "SchoolName", columnDefinition = "NVARCHAR(100)", nullable = false)
    private String schoolName;

    @Column(name = "Location", columnDefinition = "NVARCHAR(100)")
    private String location;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "school")
    private List<Student> students = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "school")
    private List<Major> majors = new ArrayList<>();

    public void addStudent(Student student){
        // add student
        students.add(student);
        student.setSchool(this);
    }

    public School(String schoolId, String schoolName, String location) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.location = location;
    }
}
