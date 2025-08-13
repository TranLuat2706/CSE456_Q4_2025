package vn.edu.eiu.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "FullName", columnDefinition = "NVARCHAR(100)", nullable = false)
    private String fullName;
    @Column(name = "Email", columnDefinition = "VARCHAR(255)")
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Invoice> invoices;

    public Customer(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }
}
