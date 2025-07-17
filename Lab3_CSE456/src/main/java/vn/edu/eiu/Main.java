package vn.edu.eiu;

import jakarta.persistence.EntityManager;
import vn.edu.eiu.entity.Gender;
import vn.edu.eiu.entity.Major;
import vn.edu.eiu.entity.School;
import vn.edu.eiu.entity.Student;
import vn.edu.eiu.infra.JpaUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Major major = new Major("CSE", "Software Engineering");
        Major major2 = new Major("CSW", "Network and Data Transportation");

        Student std1 = new Student("Tran Minh", Gender.MALE, LocalDate.parse("2000-10-10"), 8.6, 4);
        Student std2 = new Student("Nguyen Nhi", Gender.FEMALE, LocalDate.parse("2001-12-15"), 9.6, 4);
        Student std3 = new Student("Tran Van", Gender.MALE, LocalDate.parse("2001-06-20"), 8.0, 5);
        Student std4 = new Student("Van Anh", Gender.FEMALE, LocalDate.parse("1998-05-10"), 8.7, 4);

        School sc1 = new School("EIU", "Eastern International University", "Nam Ky Khoi Nghia Street...");
        School sc2 = new School("TDM", "Thu Dau Mot University", "Tran Van On Street...");

        insertStudent(std1);
        insertStudent(std2);
        insertStudent(std3);
        insertStudent(std4);
        insertMajor(major);
        insertMajor(major2);
        insertSchool(sc1);
        insertSchool(sc2);

        setSchool(std1, sc1);
        setSchool(std2, sc2);
        setSchool(std3, sc1);
        setSchool(std4, sc2);

        setMajor(std1, major);
        setMajor(std2, major);
        setMajor(std3, major2);
        setMajor(std4, major2);
    }

    public static void insertStudent(Student student) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }

    public static void getStudentById(String studentId) {
        EntityManager em = JpaUtil.getEntityManager();
        Student std1 = em.find(Student.class, studentId);
        System.out.println("Student found: " + std1.toString());
        em.close();
    }

    public static void updateStudent(Student student) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
        em.close();
    }

    public static void getAllStudents() {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        List<Student> stds = em.createQuery("select s from Student s", Student.class)
                .getResultList();
        System.out.println("All students found: ");
        stds.forEach(System.out::println);
        em.close();
    }

    public static void deleteStudent(Student student) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(student);
        em.getTransaction().commit();
        em.close();
    }

    public static void deleteStudentById(String studentId) {
        EntityManager em = JpaUtil.getEntityManager();
        Student std1 = em.find(Student.class, studentId);
        em.getTransaction().begin();
        em.remove(std1);
        em.getTransaction().commit();
        em.close();
    }

    public static void insertMajor(Major major) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(major);
        em.getTransaction().commit();
        em.close();
    }

    public static void insertSchool(School school) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(school);
        em.getTransaction().commit();
        em.close();
    }

    public static void setSchool(Student student, School school) {
        school.addStudent(student);
    }
    public static void setMajor(Student student, Major major) {
        major.addStudent(student);
    }
}