package dao;

import entity.Order;
import java.util.List;

public interface OrderDao {

    boolean addOrder(Order order);

    boolean updateOrder(Order order);

    boolean deleteOrder(int id);

    Order findOrderById(int id);

    List<Order> getAllOrders();
}