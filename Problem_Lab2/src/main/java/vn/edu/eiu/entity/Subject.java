package vn.edu.eiu.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "Subjects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Subject {
    @Id
    @Column(name = "Code", columnDefinition = "CHAR(10)")
    private String code;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)",  nullable = false)
    private String name;

    @Column(name = "Description", columnDefinition = "VARCHAR(255)")
    private String description;

    @Column(name = "Credit", nullable = false)
    private int credit;

    @Column(name = "Studyhours", nullable = false)
    private int studyhours;
}
