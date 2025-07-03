package vn.edu.eiu;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import vn.edu.eiu.entity.Course;
import vn.edu.eiu.entity.Student;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        Student std1 =  new Student("Std1", "Tran", "A", 2003, 4.0);
        Student std2 =  new Student("Std2", "Tran", "B", 2003, 4.0);
        Student std3 =  new Student("Std3", "Tran", "C", 2003, 4.0);

        Course cr1 = new Course("CSE201", "Algorithms", 4, 40.0);
        Course cr2 = new Course("CSE456", "Advance Java Programing", 4, 40.0);
        Course cr3 = new Course();
        cr3.setIdCourse("CSE203");
        cr3.setName("OOP Programing");
        cr3.setCredits(4);
        cr3.setHours(40.0);

        System.out.println("List of student:");
//        System.out.println(std1.toString());
//        System.out.println(std2.toString());
//        System.out.println(std3.toString());
//
//        System.out.println("List of course:");
//        System.out.println(cr1.toString());
//        System.out.println(cr2.toString());
//        System.out.println(cr3.toString());

        // Object -> JSON
        ObjectMapper mapper = new ObjectMapper();
        String jstd1 = mapper.writeValueAsString(std1);
        String jstd2 = mapper.writeValueAsString(std2);
        String jstd3 = mapper.writeValueAsString(std3);
        System.out.println("Student 1 with JSON: " + jstd1);
        System.out.println("Student 2 with JSON: " + jstd2);
        System.out.println("Student 3 with JSON: " + jstd3);

        // JSON (get in frontend) -> Object (change into object in backend)
        String jsonToObj = """
                {"id":"Std4","firstName":"Tran","lastName":"D","yearOfBirth":2003,"gpa":4.0}""";
        Student std4FromJson = mapper.readValue(jsonToObj, Student.class);  //change into Object in class Student
        System.out.println("Student 4: " + std4FromJson.toString());
    }
}