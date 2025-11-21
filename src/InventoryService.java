public class InventoryService {

    public void processImport(ImportOrder order) {
        order.calculateTotal();
        for (var e : order.items.entrySet()) {
            Product p = e.getKey();
            int qty = e.getValue();
            p.setQuantity(p.getQuantity() + qty);
        }
    }
        public boolean processExport(ExportOrder order) {
            for (var e : order.items.entrySet()) {
                Product p = e.getKey();
                int qty = e.getValue();
                if (p.getQuantity() < qty) {
                    System.out.println("Not enough stock for: " + p.getName());
                    return false;
                }
            }

            order.calculateTotal();

            for (var e : order.items.entrySet()) {
                Product p = e.getKey();
                int qty = e.getValue();
                p.setQuantity(p.getQuantity() - qty);
            }
            return true;
        }
    }