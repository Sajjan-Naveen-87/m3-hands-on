import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A plain-Java controller. 
 *
 * {@link #listOrders()}, {@link #getOrderById(long)}, and
 * {@link #createOrder(String, int)} are completed.
 */
public class OrderController {

    public record Order(long id, String item, int qty) {}

    private final Map<Long, Order> store = new HashMap<>();
    private long nextId = 1;

    public OrderController() {
        Order seed = new Order(nextId++, "seed-item", 1);
        store.put(seed.id(), seed);
    }

    /** GET /orders -- return every stored order. Hand-written. */
    public List<Order> listOrders() {
        return new ArrayList<>(store.values());
    }

    /** GET /orders/{id} -- return the matching order, or null if
     *  none exists. Completed with Copilot. */
    public Order getOrderById(long id) {
        return store.get(id);
    }

    /** POST /orders -- create a new order, assign it the next id,
     *  store it, and return it. Completed with Copilot. */
    public Order createOrder(String item, int qty) {
        Order order = new Order(nextId++, item, qty);
        store.put(order.id(), order);
        return order;
    }
}
