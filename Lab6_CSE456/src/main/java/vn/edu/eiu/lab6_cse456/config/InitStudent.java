package vn.edu.eiu.lab6_cse456.config;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import vn.edu.eiu.lab6_cse456.entity.Student;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitStudent {
    private List<Student> students;

    @PostConstruct
    public void initStudent() {
        students = new ArrayList<>();
        students.add(new Student(1, "Tran Van B", 2005, 9.2));
        students.add(new Student(2, "Nguyen Nhat A", 2003, 8.8));
        students.add(new Student(3, "Nguyen C", 2002, 8.6));
        students.add(new Student(4, "Tran D", 2001, 8.2));
        students.add(new Student(5, "Do Minh T", 1998, 9.4));
        System.out.println("The list of students is innitialized successfully!");
    }

    public List<Student> getStudents() {
        return students;
    }

    public void save(Student student) {
        students.add(student);
    }
}
