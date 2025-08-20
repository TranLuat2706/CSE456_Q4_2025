package vn.edu.eiu.testlab.fecse456studentiddemo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_user")
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  //id auto increase
    @Column(name = "username", unique = true, nullable = false, columnDefinition = "VARCHAR(50)")
    private String userName;
    @Column(nullable = false, columnDefinition = "VARCHAR(30)")
    private String password;
    @Column(nullable = false)
    private int role;

    //constructor with all properties except id
    public User(String password, String userName, int role) {
        this.password = password;
        this.userName = userName;
        this.role = role;
    }
}
