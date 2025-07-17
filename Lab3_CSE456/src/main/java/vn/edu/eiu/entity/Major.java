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
@Table
public class Major {
    @Id
    @Column(name = "MajorId",columnDefinition = "CHAR(4)")
    private String majorId;

    @Column(name = "MajorName", columnDefinition = "NVARCHAR(100)",nullable = false)
    private String majorName;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "SchoolID")
    private School school;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "major")
//  @JoinColumn(name = "MajorId")
    private List<Student> students = new ArrayList<>();

    //Khi có sinh viên thuộc major nào thì phải thêm vào List của major đó:
    public void addStudent(Student student){
        // add student
        students.add(student);
        //đồng thời thêm major cho student
        student.setMajor(this);
    }
    //Tạo một constructor không có tham số List student, vì student sẽ được thêm sau

    public Major(String majorId, String majorName) {
        this.majorId = majorId;
        this.majorName = majorName;
    }
}
