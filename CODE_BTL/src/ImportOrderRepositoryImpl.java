import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class ImportOrderRepositoryImpl implements ImportOrderRepository {
    private static final String FILE = "import_orders.csv";
    private List<ImportOrder> orders = new ArrayList<>();

    public ImportOrderRepositoryImpl() { load(); }

    @Override
    public void load() {
        List<String[]> rows = CsvUtils.read(FILE);
        orders.clear();
        for (String[] r : rows) {
            ImportOrder o = new ImportOrder();
            o.setProductId(r[0]);
            o.setQuantity(Integer.parseInt(r[1]));
            o.setSupplierId(r[2]);
            o.setDate(LocalDate.parse(r[3]));
            orders.add(o);
        }
    }

    @Override
    public void save() {
        List<String[]> data = new ArrayList<>();
        for (ImportOrder o : orders) {
            data.add(new String[]{o.getProductId(), String.valueOf(o.getQuantity()), o.getSupplierId(), o.getDate().toString()});
        }
        CsvUtils.write(FILE, data);
    }

    @Override
    public void add(ImportOrder o) {
        orders.add(o);
        save();
    }

    @Override
    public List<ImportOrder> findAll() { return orders; }
}
