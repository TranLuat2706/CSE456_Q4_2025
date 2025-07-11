package vn.edu.eiu;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import vn.edu.eiu.entity.Student;
import vn.edu.eiu.entity.Subject;
import vn.edu.eiu.entity.Lecturer;

import javax.lang.model.element.Name;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1-mysql-masterapp");
    public static void main(String[] args) {
//        insertStudent();
//        getStudentById();
//        getAllStudents();

//        updateStudent();
//        getStudentByGpa();

//        getStudentByConditions("B", 9.2);

//        removeStudentById("CSE2025001");
        insertSubject();
        insertLecturer();
    }

    //Định nghĩa các hàm CRUD
    public static void insertStudent() {
        //1. Gọi người quản lý việc tương tác db
        EntityManager em = emf.createEntityManager();
        //2. Chuẩn bị data để insert
        Student std1 = new Student("CSE2025001", "Tran Van A", 2000, 8.5);
        Student std2 = new Student("CSE2025002", "Tran Van B", 2002, 9.2);
        Student std3 = new Student("CSE2025003", "Tran Van C", 2001, 9.1);
        //3. Người quản lí thực hiện insert
        // Khi thực thi các câu lệnh sql dạng DML (Dât Manipulation Language : có làm thay đổi
        // dữ liệu thì bắt buộc phải đặt trong 1 transaction để đảm bảo tính ACID: Atomy
        // Consistency Isolation Durability: Một là thực thi câu lệnh từ đầu đến cuối, còn ngược
        // lại thì không làm gì cả, rollback//
        em.getTransaction().begin();
//        em.persist(std1);   // Ghi xuống db nhưng chưa thực hiện ghi
        em.persist(std2);
        em.persist(std3);
        em.getTransaction().commit(); // Đã ghi xuống db, nếu fail thì rollback
        em.close();  // nghỉ
    }

    public static void getStudentById() {
        EntityManager em = emf.createEntityManager();
        Student std1 = em.find(Student.class, "CSE2025001");
        System.out.println("Student found: " + std1.toString());
        em.close();
    }
    // Khi viết truy vấn select thì có thể dùng các loại cú pháp sql sau:
    // SQL thuần
    // HQL: đuợc chỉnh sửa bởi hibernate
    // JPQL: được chỉnh sửa bởi JPA lệnh truy vấn theo kiểu OOP //
    public static void getAllStudents() {
        EntityManager em = emf.createEntityManager();
        List<Student> stds = em.createQuery("select s from Student s", Student.class)
                .getResultList();
        System.out.println("All students found: ");
        stds.forEach(System.out::println);
        em.close();
    }

    public static void getStudentByGpa() {
        EntityManager em = emf.createEntityManager();
        List<Student> stds = em.createQuery("select s from Student s where s.gpa > 9"
                , Student.class).getResultList();
        System.out.println(stds.size() + " students found: ");
        stds.forEach(System.out::println);
        em.close();
    }

    public static void updateStudent() {
        EntityManager em = emf.createEntityManager();
        Student std1 = em.find(Student.class, "CSE2025001");

        em.getTransaction().begin();
        std1.setGpa(9.5);
        em.merge(std1);
        em.getTransaction().commit();
        em.close();
    }

    // Cập nhật năm sinh dựa vào ID (có transaction)
    public static void updateStudentByID() {
        EntityManager em = emf.createEntityManager();
        Student std1 = em.find(Student.class, "CSE2025001");

        em.getTransaction().begin();
        std1.setYob(2007);
        em.merge(std1);
        em.getTransaction().commit();
        em.close();
    }

    // Tìm sv theo nhiều đk được truyền vào (tên , gpa được truyền vào)
    public static void getStudentByConditions(String Name, double Gpa) {
        EntityManager em = emf.createEntityManager();
        List<Student> stds = em.createQuery("select s from Student s where s.name like :sName or s.gpa > :sGpa")
                .setParameter("sName", "%" + Name + "%").setParameter("sGpa", Gpa).getResultList();
        System.out.println(stds.size() + " students found: ");
        stds.forEach(System.out::println);
        em.close();
    }

    public static void removeStudentById(String id) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Student std1 = em.find(Student.class, id);
        em.remove(std1);
        em.getTransaction().commit();
        System.out.println("Remove student: " + std1.toString());
        em.close();
    }

    public static void insertSubject() {
        EntityManager em = emf.createEntityManager();
        Subject sj1 = new Subject("CSE203", "OOP Programing", "Lập trình hướng đối tượng", 4, 40);
        em.getTransaction().begin();
        em.persist(sj1);
        em.getTransaction().commit();
        em.close();
    }

    public static void insertLecturer() {
        EntityManager em = emf.createEntityManager();
        Lecturer lt1 = new Lecturer(001, "Nguyen Van A", 1980, 15000000);
        em.getTransaction().begin();
        em.persist(lt1);
        em.getTransaction().commit();
        em.close();
    }
}