public class InventoryAudit {

    public void audit(Product p, int realQuantity) {
        int system = p.getQuantity();
        int diff = realQuantity - system;

        System.out.println("System: " + system);
        System.out.println("Real: " + realQuantity);
        System.out.println("Diff: " + diff);

        if (diff != 0) {
            p.setQuantity(realQuantity);
        }
    }
}