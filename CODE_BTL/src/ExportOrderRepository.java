import java.util.List;

public interface ExportOrderRepository {
    void load();
    void save();
    void add(ExportOrder o);
    List<ExportOrder> findAll();
}
