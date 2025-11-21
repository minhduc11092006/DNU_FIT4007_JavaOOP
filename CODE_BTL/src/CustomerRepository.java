import java.util.List;

public interface CustomerRepository {
    void load();
    void save();
    void add(Customer c);
    List<Customer> findAll();
    Customer findById(String id);
}
