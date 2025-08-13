package vn.edu.eiu.Repo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import vn.edu.eiu.Config.HibernateUtil;
import vn.edu.eiu.Entities.Product;

public class ProductRepo {
    public Product saveOrUpdate(Product product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Product merged = (Product) session.merge(product);
        tx.commit();
        session.close();
        return merged;
    }
}
