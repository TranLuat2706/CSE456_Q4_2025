package vn.edu.eiu.Services;

import vn.edu.eiu.Entities.Customer;
import vn.edu.eiu.Entities.Invoice;
import vn.edu.eiu.Entities.Product;
import vn.edu.eiu.Repo.CustomerRepo;
import vn.edu.eiu.Repo.InvoiceRepo;
import vn.edu.eiu.Repo.ProductRepo;

import java.util.List;

public class InvoiceServices {
    private final CustomerRepo customerRepo;
    private final ProductRepo productRepo;
    private final InvoiceRepo invoiceRepo;

    public InvoiceServices(CustomerRepo customerRepo, ProductRepo productRepo, InvoiceRepo invoiceRepo) {
        this.customerRepo = customerRepo;
        this.productRepo = productRepo;
        this.invoiceRepo = invoiceRepo;
    }

    public void createInvoice(Customer customer, List<Product> products) {
        customer = customerRepo.saveOrUpdate(customer);

        for (int i = 0; i < products.size(); i++) {
            products.set(i, productRepo.saveOrUpdate(products.get(i)));
        }

        double total = products.stream().mapToDouble(Product::getPrice).sum();

        Invoice invoice = new Invoice();
        invoice.setCustomer(customer);
        invoice.setProducts(products);
        invoice.setTotalPrice(total);
        invoiceRepo.save(invoice);

        System.out.println("Invoice created for customer: " + customer.getFullName());
        System.out.println("Total price: $" + total);
    }
}
