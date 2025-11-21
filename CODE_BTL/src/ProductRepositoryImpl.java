import java.util.List;
import java.util.ArrayList;

public class ProductRepositoryImpl implements ProductRepository {
    private static final String FILE = "products.csv";
    private List<Product> products = new ArrayList<>();

    public ProductRepositoryImpl() { load(); }

    @Override
    public void load() {
        List<String[]> rows = CsvUtils.read(FILE);
        products.clear();
        for (String[] r : rows) {
            Product p = new Product();
            p.setId(r[0]); p.setName(r[1]); p.setCategory(r[2]);
            p.setImportPrice(Double.parseDouble(r[3]));
            p.setExportPrice(Double.parseDouble(r[4]));
            p.setStock(Integer.parseInt(r[5]));
            products.add(p);
        }
    }

    @Override
    public void save() {
        List<String[]> data = new ArrayList<>();
        for (Product p : products) {
            data.add(new String[]{
                    p.getId(), p.getName(), p.getCategory(),
                    String.valueOf(p.getImportPrice()),
                    String.valueOf(p.getExportPrice()),
                    String.valueOf(p.getStock())
            });
        }
        CsvUtils.write(FILE, data);
    }

    @Override
    public void add(Product p) {
        products.add(p);
        save();
    }

    @Override
    public List<Product> findAll() { return products; }

    @Override
    public Product findById(String id) throws ProductNotFoundException {
        for (Product p : products) {
            if (p.getId().equals(id)) return p;
        }
        throw new ProductNotFoundException("Không tìm thấy sản phẩm: " + id);
    }
}
