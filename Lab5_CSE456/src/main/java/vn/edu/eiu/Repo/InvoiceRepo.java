package vn.edu.eiu.Repo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import vn.edu.eiu.Config.HibernateUtil;
import vn.edu.eiu.Entities.Invoice;

public class InvoiceRepo {
    public void save(Invoice invoice) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.merge(invoice);
        tx.commit();
        session.close();
    }
}
