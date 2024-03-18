package dao.daoImpl;

import dao.InsuranceDao;
import entity.Insurance;
import entity.Order;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sessionFactory.SessionFactoryImpl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class InsuranceDaoImpl implements InsuranceDao {
    @Override
    public boolean addInsurance(Insurance insurance) {
        boolean isAdded = false;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(insurance);
            tx.commit();
            session.close();
            isAdded = true;
        } catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return isAdded;
    }

    @Override
    public boolean updateInsurance(Insurance insurance) {
        boolean isUpdated = false;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.update(insurance);
            tx.commit();
            session.close();
            isUpdated = true;
        } catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return isUpdated;
    }

    @Override
    public boolean deleteInsurance(int id) {
        boolean isDeleted = false;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Insurance insurance = session.load(Insurance.class, id);
            Transaction tx = session.beginTransaction();
            session.delete(insurance);
            tx.commit();
            session.close();
            isDeleted = true;
        } catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return isDeleted;
    }

    @Override
    public List<Insurance> showInsurance() {
        List<Insurance> people = (List<Insurance>) SessionFactoryImpl.getSessionFactory().openSession().createQuery("FROM Insurance").list();
        return people;
    }

    @Override
    public Insurance findInsuranceById(int id) {
        Insurance insurance = null;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            insurance = session.get(Insurance.class, id);
            session.close();
        } catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return insurance;
    }
}