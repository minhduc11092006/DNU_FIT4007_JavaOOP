public class ImportOrder extends Order {
    private String supplier;

    public ImportOrder(String orderId, String supplier) {
        super(orderId);
        this.supplier = supplier;
    }

    @Override
    public void calculateTotal() {
        totalAmount = 0;
        for (var entry : items.entrySet()) {
            Product p = entry.getKey();
            int qty = entry.getValue();
            totalAmount += p.baseCost * qty;
        }
    }
}