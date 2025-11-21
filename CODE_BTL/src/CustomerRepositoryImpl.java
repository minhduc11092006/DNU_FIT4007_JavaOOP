import java.util.List;
import java.util.ArrayList;

public class CustomerRepositoryImpl implements CustomerRepository {
    private static final String FILE = "customers.csv";
    private List<Customer> customers = new ArrayList<>();

    public CustomerRepositoryImpl() { load(); }

    @Override
    public void load() {
        List<String[]> rows = CsvUtils.read(FILE);
        customers.clear();
        for (String[] r : rows) {
            Customer c = new Customer(r[0], r[1], r[2]);
            customers.add(c);
        }
    }

    @Override
    public void save() {
        List<String[]> data = new ArrayList<>();
        for (Customer c : customers) {
            data.add(new String[]{c.getId(), c.getName(), c.getPhone()});
        }
        CsvUtils.write(FILE, data);
    }

    @Override
    public void add(Customer c) {
        customers.add(c);
        save();
    }

    @Override
    public List<Customer> findAll() { return customers; }

    @Override
    public Customer findById(String id) {
        for (Customer c : customers) {
            if (c.getId().equals(id)) return c;
        }
        return null;
    }
}
