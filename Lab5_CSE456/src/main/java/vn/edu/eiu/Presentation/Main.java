package vn.edu.eiu.Presentation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vn.edu.eiu.Config.AppConfig;
import vn.edu.eiu.Entities.Customer;
import vn.edu.eiu.Entities.Product;
import vn.edu.eiu.Repo.CustomerRepo;
import vn.edu.eiu.Services.InvoiceServices;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        InvoiceServices service = context.getBean(InvoiceServices.class);


        Customer c1 = new Customer("Tran Van A", "a@gmail.com");

        Product p1 = new Product("Smartphone", 2500);
        Product p2 = new Product("Laptop", 7800);

        service.createInvoice(c1, Arrays.asList(p1, p2));
        context.close();
    }
}