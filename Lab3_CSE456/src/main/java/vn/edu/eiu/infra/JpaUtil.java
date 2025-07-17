package vn.edu.eiu.infra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/** + lớp này sẽ khởi tạo kết nối db = đọc thông tin trong persistance unit
 *  => load nhiều thông tin cấu hình, xóa cấu trúc bảng, tạo lại bảng => quá
 *  nặng => chỉ nên load 1 lần duy nhất => dùng kĩ thuật SINGLETON để làm.
 *
 *  + tạo ra đối tượng quản lí việc tương tác với db (EntityManager)
 */
public class JpaUtil {
    private static final EntityManagerFactory emf;

    //hàm static ko tên, sẽ được gọi ngay khi lớp JpaUtil được chọn
    static {
        try{
            emf = Persistence.createEntityManagerFactory
                    ("pu1_Lab3_CSE456");
        } catch (Exception e) {
            System.out.println("Can't create entity pu1_Lab3_CSE456");
            throw new RuntimeException(e);
        }
    }
    // để đoạn code static trên chạy được thì cần phải vô hiệu hóa tất cả constructor.
    // Mặc định ko khai báo constructor thì class sẽ kế thừa constructor rỗng của
    // class object

    private  JpaUtil() {} // vô hiệu hóa constructor kế thừa từ obj

    // Tạo ra EntityManager quản lí việc tương tác với db
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
