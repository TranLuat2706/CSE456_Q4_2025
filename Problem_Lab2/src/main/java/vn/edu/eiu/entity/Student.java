package vn.edu.eiu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Table(name = "Students")   //Nếu cần đặt name bảng khác với class
     //lombok generate constructors
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    @Id    //Đánh dấu cột khóa chính
    @Column(name = "ID", columnDefinition = "CHAR(10)")
    private String id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    private String name;

    @Column(name = "Year of Birth", nullable = false)
    private int yob;

    @Column(name = "Gpa")
    private double gpa;
}
