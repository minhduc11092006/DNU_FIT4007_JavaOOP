import java.util.List;
import java.util.ArrayList;

public class SupplierRepositoryImpl implements SupplierRepository {
    private static final String FILE = "suppliers.csv";
    private List<Supplier> suppliers = new ArrayList<>();

    public SupplierRepositoryImpl() { load(); }

    @Override
    public void load() {
        List<String[]> rows = CsvUtils.read(FILE);
        suppliers.clear();
        for (String[] r : rows) {
            Supplier s = new Supplier(r[0], r[1], r[2]);
            suppliers.add(s);
        }
    }

    @Override
    public void save() {
        List<String[]> data = new ArrayList<>();
        for (Supplier s : suppliers) {
            data.add(new String[]{s.getId(), s.getName(), s.getPhone()});
        }
        CsvUtils.write(FILE, data);
    }

    @Override
    public void add(Supplier s) {
        suppliers.add(s);
        save();
    }

    @Override
    public List<Supplier> findAll() { return suppliers; }

    @Override
    public Supplier findById(String id) {
        for (Supplier s : suppliers) {
            if (s.getId().equals(id)) return s;
        }
        return null;
    }
}
