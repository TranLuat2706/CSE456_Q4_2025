package vn.edu.eiu.Presentation;


import vn.edu.eiu.Data.BankTransferPayment;
import vn.edu.eiu.Data.CardPayment;
import vn.edu.eiu.Data.EwalletPayment;
import vn.edu.eiu.Data.PaymentMethod;
import vn.edu.eiu.Service.PaymentService;

public class Main {
    public static void main(String[] args) {
        PaymentMethod pm1 = new BankTransferPayment();
        PaymentService ps1 = new PaymentService(pm1);
        ps1.processPayment(200);

        PaymentMethod pm2 = new CardPayment();
        PaymentService ps2 = new PaymentService(pm2);
        ps2.processPayment(300);

        PaymentMethod pm3 = new EwalletPayment();
        PaymentService ps3 = new PaymentService(pm3);
        ps3.processPayment(400);
    }
}