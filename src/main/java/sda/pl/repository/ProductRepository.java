package sda.pl.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import sda.pl.HibernateUtil;
import sda.pl.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class ProductRepository {

    public static boolean saveProduct (Product product) {
        Session session = null;

        try {
            session = HibernateUtil.openSession();

            session.save(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }


    }

    public static boolean saveOrUpdateProduct (Product product) {
        Session session = null;

        try {
            session = HibernateUtil.openSession();
            session.getTransaction().begin();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null && session.isOpen() && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }

            return false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }


    }

    public static Optional<Product> findProduct(Long id) {
        Session session = null;

        try {
            session = HibernateUtil.openSession();
            Product product = session.find(Product.class, id);
            return Optional.ofNullable(product);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    public static List<Product> findAll() {
        Session session = null;

        try {
            session = HibernateUtil.openSession();
            String hql = "SELECT p FROM Product p ";
            Query query = session.createQuery(hql);
            List resultList = query.getResultList();
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    public static List<Product> findAllWithPriceNetLessThan(BigDecimal price) {
        Session session = null;

        try {
            session = HibernateUtil.openSession();
            String hql = "SELECT p FROM Product p WHERE p.price.priceNet < :price " + // przed parametrem ":"
                    "ORDER BY p.price.priceNet DESC";
            Query query = session.createQuery(hql);
            query.setParameter("price", price);
            query.setMaxResults(100); //pobrać tylko 100 elementów
//            query.setFirstResult() // pomiń pierwsze x produktów
            List resultList = query.getResultList();
            return resultList;



        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public static Long countAll () {
        Session session = null;

        try {
            session = HibernateUtil.openSession();
            String hql = "SELECT COUNT(p) FROM Product p";
            Query query = session.createQuery(hql);
            Long singleResult = (Long) query.getSingleResult();
            return singleResult;
        } catch (Exception e) {
            e.printStackTrace();
            return 0l;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }


    }

}
