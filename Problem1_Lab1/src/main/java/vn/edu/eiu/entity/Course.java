package vn.edu.eiu.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Course {
    private String idCourse;
    private String name;
    private int credits;
    private double hours;
}
