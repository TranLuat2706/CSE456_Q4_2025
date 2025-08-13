package vn.edu.eiu.Repo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import vn.edu.eiu.Config.HibernateUtil;
import vn.edu.eiu.Entities.Customer;

public class CustomerRepo {
    public Customer saveOrUpdate(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Customer merged = (Customer) session.merge(customer);
        tx.commit();
        session.close();
        return merged;
    }
}
