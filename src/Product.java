import java.io.Serializable;

public abstract class Product implements Serializable {
    protected String ID;
    protected String name;
    protected String category;
    protected double baseCost;
    protected double sellPrice;
    protected int quantity;

    public Product(String ID, String name, String category, double baseCost, double sellPrice, int quantity){
        this.ID = ID;
        this.name = name;
        this.category = category;
        this.baseCost = baseCost;
        this.sellPrice = sellPrice;
        this.quantity = quantity;
    }

    public abstract String getDetail();

    //Duy Anh
}
