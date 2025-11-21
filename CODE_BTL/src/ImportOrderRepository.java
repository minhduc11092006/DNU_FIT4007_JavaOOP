import java.util.List;

public interface ImportOrderRepository {
    void load();
    void save();
    void add(ImportOrder o);
    List<ImportOrder> findAll();
}
