package vn.edu.eiu.Data;

public class EwalletPayment implements PaymentMethod {
    @Override
    public void makePayment(double amount) {
        System.out.println("Processing eWallet payment of $" + amount);
    }
}
