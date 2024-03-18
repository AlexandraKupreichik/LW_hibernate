package service.serviceImpl;

import java.util.List;

import dao.OrderDao;
import dao.daoImpl.OrderDaoImpl;
import entity.Company;
import entity.Order;
import exception.ShowException;
import org.hibernate.HibernateError;
import service.OrderService;


public class OrderServiceImpl implements OrderService {

    OrderDao orderDao = new OrderDaoImpl();

    public OrderServiceImpl() {}

    @Override
    public boolean addOrder(Order order) {
        boolean isAdded = false;
        try {
            orderDao.addOrder(order);
            isAdded = true;
        }
        catch (HibernateError e) {
            ShowException.showNotice(e);
        }
        return isAdded;
    }

    @Override
    public boolean updateOrder(Order order) {
        boolean isUpdated = false;
        try {
            if (orderDao.updateOrder(order))
                isUpdated = true;
        }
        catch (HibernateError e) {
            ShowException.showNotice(e);
        }
        return isUpdated;
    }

    @Override
    public boolean deleteOrder(int id) {
        boolean isDeleted = false;
        try {
            if (orderDao.deleteOrder(id))
                isDeleted = true;
        }
        catch (HibernateError e) {
            ShowException.showNotice(e);
        }
        return isDeleted;
    }

    @Override
    public List<Order> showOrders() {
        List<Order> order = null;
        try {
            order = orderDao.getAllOrders();
        }
        catch (HibernateError e) {
            ShowException.showNotice(e);
        }
        return order;
    }

    @Override
    public Order findOrderById(int id) {
        Order order = null;
        try {
            order = orderDao.findOrderById(id);
        }
        catch (HibernateError e) {
            ShowException.showNotice(e);
        }
        return order;
    }

}
