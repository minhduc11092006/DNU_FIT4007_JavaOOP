import java.time.LocalDate;

public class Food extends Product {
    private LocalDate expirationDate;

    public Food(String id, String name, double baseCost, double sellPrice,
                int quantity, LocalDate expirationDate) {
        super(id, name, baseCost, sellPrice, quantity);
        this.category = "Food";
        this.expirationDate = expirationDate;
    }

    @Override
    public String getDetail() {
        return "Expiration: " + expirationDate;
    }
}
