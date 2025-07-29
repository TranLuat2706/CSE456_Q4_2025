package vn.edu.eiu.Data;

public class CardPayment implements PaymentMethod {
    @Override
    public void makePayment(double amount) {
        System.out.println("Processing credit/debit card payment of $" + amount);
    }
}
