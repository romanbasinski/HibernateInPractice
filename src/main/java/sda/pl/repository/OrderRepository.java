package sda.pl.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import sda.pl.HibernateUtil;
import sda.pl.domain.Order;

import java.util.Collections;
import java.util.List;

public class OrderRepository {

    public static boolean saveOrder(Order order) {
        Session session = null;

        try {
            session = HibernateUtil.openSession();
            session.save(order);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }


    }

    public static List<Order> findAll() {
        Session session = null;

        try {
            session = HibernateUtil.openSession();
            String hql = "SELECT o FROM Order o JOIN FETCH o.orderDetailSet";
            Query query = session.createQuery(hql);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }


    }

    public static List<Order> findAllWithProductName(String produceName) {
        Session session = null;

        try {
            session = HibernateUtil.openSession();
            String hql = "SELECT o FROM Order o JOIN FETCH o.orderDetailSet od WHERE od.product.name like :productName ";  // przed parametrem ":"
            Query query = session.createQuery(hql);
            query.setParameter("productName", "%"+produceName+"%");
            return query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }


}
