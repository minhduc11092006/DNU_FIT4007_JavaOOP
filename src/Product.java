public abstract class Product{
    protected String id;
    protected String name;
    protected String category;
    protected double baseCost;
    protected double sellPrice;
    protected int quantity;

    public Product(String id, String name, double baseCost, double sellPrice, int quantity){
        this.id = id;
        this.name = name;
        this.baseCost = baseCost;
        this.sellPrice = sellPrice;
        this.quantity = quantity;
    }

    public abstract String getDetail();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public double getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(double baseCost) {
        this.baseCost = baseCost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}