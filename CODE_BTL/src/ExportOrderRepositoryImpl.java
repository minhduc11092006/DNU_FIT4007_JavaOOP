import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class ExportOrderRepositoryImpl implements ExportOrderRepository {
    private static final String FILE = "export_orders.csv";
    private List<ExportOrder> orders = new ArrayList<>();

    public ExportOrderRepositoryImpl() { load(); }

    @Override
    public void load() {
        List<String[]> rows = CsvUtils.read(FILE);
        orders.clear();
        for (String[] r : rows) {
            ExportOrder o = new ExportOrder();
            o.setProductId(r[0]);
            o.setQuantity(Integer.parseInt(r[1]));
            o.setCustomerId(r[2]);
            o.setDate(LocalDate.parse(r[3]));
            orders.add(o);
        }
    }

    @Override
    public void save() {
        List<String[]> data = new ArrayList<>();
        for (ExportOrder o : orders) {
            data.add(new String[]{o.getProductId(), String.valueOf(o.getQuantity()), o.getCustomerId(), o.getDate().toString()});
        }
        CsvUtils.write(FILE, data);
    }

    @Override
    public void add(ExportOrder o) {
        orders.add(o);
        save();
    }

    @Override
    public List<ExportOrder> findAll() { return orders; }
}
