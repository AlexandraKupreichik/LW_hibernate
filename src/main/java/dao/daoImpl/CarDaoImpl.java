package dao.daoImpl;

import dao.CarDao;
import entity.Car;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sessionFactory.SessionFactoryImpl;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CarDaoImpl implements CarDao {

    public CarDaoImpl() {
    }

    @Override
    public boolean addCar(Car car) {
        boolean isAdded = false;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(car);
            tx.commit();
            session.close();
            isAdded = true;
        } catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return isAdded;
    }

    @Override
    public boolean updateCar(Car car) {
        boolean isUpdated = false;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.update(car);
            tx.commit();
            session.close();
            isUpdated = true;
        } catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return isUpdated;
    }

    @Override
    public boolean deleteCar(int id) {
        boolean isDeleted = false;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            Car car = session.get(Car.class, id);
            session.delete(car);
            tx.commit();
            session.close();
            isDeleted = true;
        } catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return isDeleted;
    }

    @Override
    public Car findCarById(int id) {
        Car car = null;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            car = session.get(Car.class, id);
            session.close();
        } catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return car;
    }

    @Override
    public Car findCarByName(String name) {
        Car car = null;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Car> criteria = builder.createQuery(Car.class);
            Root<Car> root = criteria.from(Car.class);
            criteria.select(root).where(builder.equal(root.get("name"), name));
            car = session.createQuery(criteria).getSingleResult();
            session.close();
        } catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return car;
    }

    @Override
    public List<Car> showCars() {
        List<Car> cars = null;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Car> criteria = builder.createQuery(Car.class);
            Root<Car> root = criteria.from(Car.class);
            criteria.select(root);
            cars = session.createQuery(criteria).getResultList();
            session.close();
        } catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }

        return cars;
    }
}
