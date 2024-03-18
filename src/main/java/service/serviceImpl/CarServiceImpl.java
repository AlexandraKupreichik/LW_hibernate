package service.serviceImpl;


import dao.CarDao;
import dao.daoImpl.CarDaoImpl;
import entity.Car;
import entity.Company;
import exception.ShowException;
import org.hibernate.HibernateError;
import service.CarService;

import java.util.List;

public class CarServiceImpl implements CarService {

    CarDao carDao = new CarDaoImpl();

    public CarServiceImpl() {}

    @Override
    public boolean addCar(Car car) {
        boolean isAdded = false;
        try {
            carDao.addCar(car);
            isAdded = true;
        }
        catch (HibernateError e) {
            ShowException.showNotice(e);
        }
        return isAdded;
    }


    @Override
    public boolean updateCar(Car car) {
        boolean isUpdated = false;
        try {
            if (carDao.updateCar(car))
                isUpdated = true;
        }
        catch (HibernateError e) {
            ShowException.showNotice(e);
        }
        return isUpdated;
    }

    @Override
    public boolean deleteCar(int id) {
        boolean isDeleted = false;
        try {
            if (carDao.deleteCar(id))
                isDeleted = true;
        }
        catch (HibernateError e) {
            ShowException.showNotice(e);
        }
        return isDeleted;
    }

    @Override
    public List<Car> showCars() {
        List<Car> cars = null;
        try {
            cars = carDao.showCars();
        }
        catch (HibernateError e) {
            ShowException.showNotice(e);
        }
        return cars;
    }

    @Override
    public Car findCarById(int id) {
        Car car = null;
        try {
            car = carDao.findCarById(id);
        }
        catch (HibernateError e) {
            ShowException.showNotice(e);
        }
        return car;
    }

    @Override
    public Car findCarByName(String name) {
        Car car = null;
        try {
            car = carDao.findCarByName(name);
        }
        catch (HibernateError e) {
            ShowException.showNotice(e);
        }
        return car;
    }
}
