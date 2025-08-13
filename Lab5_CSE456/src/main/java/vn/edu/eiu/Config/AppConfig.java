package vn.edu.eiu.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.edu.eiu.Repo.*;
import vn.edu.eiu.Services.InvoiceServices;

@Configuration
public class AppConfig {
    @Bean
    public CustomerRepo customerRepo() {
        return new CustomerRepo();
    }

    @Bean
    public ProductRepo productRepo() {
        return new ProductRepo();
    }

    @Bean
    public InvoiceRepo invoiceRepo() {
        return new InvoiceRepo();
    }

    @Bean
    public InvoiceServices invoiceServices() {
        return new InvoiceServices(customerRepo(),productRepo(),invoiceRepo());
    }
}
