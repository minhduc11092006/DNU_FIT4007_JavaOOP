import java.util.List;

public interface ProductRepository {
    void load();
    void save();
    void add(Product p);
    List<Product> findAll();
    Product findById(String id) throws ProductNotFoundException;
}
