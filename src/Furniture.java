public class Furniture extends Product {
    private String material;
    private double weight;

    public Furniture(String id, String name, double baseCost, double sellPrice,
                     int quantity, String material, double weight) {
        super(id, name, baseCost, sellPrice, quantity);
        this.category = "Furniture";
        this.material = material;
        this.weight = weight;
    }

    @Override
    public String getDetail() {
        return "Material: " + material + ", Weight: " + weight;
    }
}
