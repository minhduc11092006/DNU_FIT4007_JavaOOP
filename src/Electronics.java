public class Electronics extends Product{
    private int warrantyMonths;
    private int power;

    public Electronics(String id, String name, double baseCost, double sellPrice,
                       int quantity, int warrantyMonths, int power) {
        super(id, name, baseCost, sellPrice, quantity);
        this.category = "Electronics";
        this.warrantyMonths = warrantyMonths;
        this.power = power;
    }

    @Override
    public String getDetail() {
        return "Warranty: " + warrantyMonths + " months, Power: " + power + "W";
    }
}