package vn.edu.eiu.Data;

public class BankTransferPayment implements PaymentMethod {
    @Override
    public void makePayment(double amount) {
        System.out.println("Processing bank transfer of $" + amount);
    }
}
