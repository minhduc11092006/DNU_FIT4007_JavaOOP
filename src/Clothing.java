public class Clothing extends Product{
    private String size;
    private String gender;

    public Clothing(String id, String name, double baseCost, double sellPrice, int quantity, String size, String gender){
        super(id, name,baseCost, sellPrice, quantity);
        this.category = "Clothing";
        this.size = size;
        this.gender = gender;
    }

    @Override
    public String getDetail() {
        return "Size: " + size + ", Gender: " + gender;
    }
}
