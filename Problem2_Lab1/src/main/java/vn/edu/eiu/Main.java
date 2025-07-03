package vn.edu.eiu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        //Sử dụng các class cung cấp sẵn có trong thư viên JDBC (có trong JAVA SDK)
        //JDBC sẽ tự động kết nối với MySQL JDBC Server (MySQL connector/java)
        try {
            String url = "jdbc:mysql://localhost:3306/cse456_2025";

            //Đối với Java mới thì Driver sẽ được tự động dò tìm trong URL mà ko cần lệnh này.
            //Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(url,"root","taluat2706");
            System.out.println("Connected to database successfully");

            //Sau khi kết nối thành công thì tiếp tục thực hiện truy vấn bằng SQL
            //Tạo Class PreparedStatement để thực hiện câu truy vấn.
            PreparedStatement pstmt = conn.prepareStatement("select * from student"); //gõ lệnh chưa chạy

            ResultSet rs = pstmt.executeQuery();  // chạy lệnh SQL và lưu danh sách vào rs

            //Duyệt qua list để xuất kết quả
//            while (rs.next()) {
//                System.out.println(rs.getString("ID" + "|"));
//                System.out.println(rs.getString("FirstName" + "|"));
//                System.out.println(rs.getString("LastName" + "|"));
//                System.out.println(rs.getInt("yob" + "|"));
//                System.out.println(rs.getDouble("gpa"));
//            }
            while (rs.next()) {
                System.out.printf("|%4s|%-10s|%-10s|%4s|%4s\n",
                        rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5));
            }
            conn.close();
            System.out.println("Connection closed.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}