package vn.edu.eiu.Service;

import vn.edu.eiu.Data.PaymentMethod;

public class PaymentService {
    // Single Responsibility
    private PaymentMethod paymentMethod;

    public PaymentService(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void processPayment(double amount) {
        paymentMethod.makePayment(amount);
    }
}
