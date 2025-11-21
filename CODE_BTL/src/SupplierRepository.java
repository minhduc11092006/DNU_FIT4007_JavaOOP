import java.util.List;

public interface SupplierRepository {
    void load();
    void save();
    void add(Supplier s);
    List<Supplier> findAll();
    Supplier findById(String id);
}
