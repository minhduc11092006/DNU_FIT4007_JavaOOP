public class Product {
    private String id;
    private String name;
    private String category;
    private double importPrice;
    private double exportPrice;
    private int stock;

    public Product() {}
    public Product(String id, String name, String category, double importPrice, double exportPrice, int stock) {
        this.id = id; this.name = name; this.category = category;
        this.importPrice = importPrice; this.exportPrice = exportPrice;
        this.stock = stock;
    }

    // getters & setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public double getImportPrice() { return importPrice; }
    public void setImportPrice(double importPrice) { this.importPrice = importPrice; }
    public double getExportPrice() { return exportPrice; }
    public void setExportPrice(double exportPrice) { this.exportPrice = exportPrice; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return id + " | " + name + " | " + category + " | Stock: " + stock;
    }
}
