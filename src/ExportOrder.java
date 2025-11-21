public class ExportOrder extends Order {
    private String customer;

    public ExportOrder(String orderId, String customer) {
        super(orderId);
        this.customer = customer;
    }

    @Override
    public void calculateTotal() {
        totalAmount = 0;
        for (var entry : items.entrySet()) {
            Product p = entry.getKey();
            int qty = entry.getValue();
            totalAmount += p.sellPrice * qty;
        }
    }
}