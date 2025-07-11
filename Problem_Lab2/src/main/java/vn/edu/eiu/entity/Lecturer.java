package vn.edu.eiu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "Lecturers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Lecturer {
    @Id
    @Column(name = "Id", columnDefinition = "BIGINT")
    private int id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    private String name;

    @Column(name = "Year of Birth",  nullable = false)
    private int yob;

    @Column(name = "Salary")
    private double salary;
}
