import java.time.LocalDate;

public class Warehouse {
    private ProductRepository productRepo;
    private ImportOrderRepository importRepo;
    private ExportOrderRepository exportRepo;

    public Warehouse(ProductRepository productRepo, ImportOrderRepository importRepo, ExportOrderRepository exportRepo) {
        this.productRepo = productRepo;
        this.importRepo = importRepo;
        this.exportRepo = exportRepo;
    }

    public void importProduct(String productId, int quantity, String supplierId) {
        try {
            Product p = productRepo.findById(productId);
            p.setStock(p.getStock() + quantity);

            ImportOrder order = new ImportOrder();
            order.setProductId(productId);
            order.setQuantity(quantity);
            order.setSupplierId(supplierId);
            order.setDate(LocalDate.now());

            importRepo.add(order);
            productRepo.save();
        } catch (ProductNotFoundException e) {
            System.out.println("Không tìm thấy sản phẩm để nhập!");
        }
    }

    public void exportProduct(String productId, int quantity, String customerId) throws OutOfStockException {
        try {
            Product p = productRepo.findById(productId);
            if (p.getStock() < quantity) throw new OutOfStockException("Tồn kho không đủ!");
            p.setStock(p.getStock() - quantity);

            ExportOrder order = new ExportOrder();
            order.setProductId(productId);
            order.setQuantity(quantity);
            order.setCustomerId(customerId);
            order.setDate(LocalDate.now());

            exportRepo.add(order);
            productRepo.save();
        } catch (ProductNotFoundException e) {
            System.out.println("Không tìm thấy sản phẩm!");
        }
    }

    public void displayAllProducts() {
        for (Product p : productRepo.findAll()) {
            System.out.println(p);
        }
    }
}
