package sda.pl.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import sda.pl.HibernateUtil;
import sda.pl.domain.ProductRating;

import java.util.List;
import java.util.Optional;

public class ProductRatingRepository {
    public static Long saveOrUpdate(ProductRating productRating) {
        Session session = null;

        try {
            session = HibernateUtil.openSession();
            session.getTransaction().begin();
            session.saveOrUpdate(productRating);
            session.getTransaction().commit();
            return productRating.getId();
        } catch (Exception e) {
            if (session != null && session.isOpen() && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return -1L;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }


    public static Optional<ProductRating> findProductRating(Long id) {
        Session session = null;

        try {
            session = HibernateUtil.openSession();
            return Optional.ofNullable(session.find(ProductRating.class, id));
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public static List<ProductRating> findAllActiveByProductId(Long productId) {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            String hql = "SELECT pr FROM ProductRating pr WHERE pr.product.id = :productId AND (pr.isActive = true " +
                    " OR pr.rate > 4) ORDER BY pr.id DESC";
            Query query = session.createQuery(hql);
            query.setParameter("productId", productId);
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

}
