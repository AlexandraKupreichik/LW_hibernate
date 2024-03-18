package service;
import entity.Order;
import java.util.List;

public interface OrderService {

    boolean addOrder(Order order);
    boolean updateOrder(Order order);
    boolean deleteOrder(int id);
    List<Order> showOrders();
    Order findOrderById(int id);
}
