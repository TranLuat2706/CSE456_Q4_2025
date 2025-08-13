package vn.edu.eiu.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "ProductName", columnDefinition = "NVARCHAR(255)", nullable = false)
    private String name;
    @Column(name = "Price", nullable = false)
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
