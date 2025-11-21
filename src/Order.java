import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public abstract class Order {
    protected String orderId;
    protected LocalDate date;
    protected Map<Product, Integer> items = new HashMap<>();
    protected double totalAmount;

    public Order(String orderId) {
        this.orderId = orderId;
        this.date = LocalDate.now();
    }

    public void addItem(Product p, int quantity) {
        items.put(p, items.getOrDefault(p, 0) + quantity);
    }

    public abstract void calculateTotal();

    public double getTotalAmount() { return totalAmount; }
}
