package code.up.bar.orders;

import java.util.LinkedList;
import java.util.List;

/**
 * Collection of OrderItems, with a tip.
 * @author Peter C
 */
public class Order {
    
    private final List<OrderItem> orders;
    private final int tip;

    public Order(int tip) {
        this.orders = new LinkedList<>();
        this.tip = tip;
    }

    public void addOrderItem(OrderItem item){
        this.orders.add(item);
    }
    
    public List<OrderItem> getOrders() {
        return orders;
    }

    public int getTip() {
        return tip;
    }
}
