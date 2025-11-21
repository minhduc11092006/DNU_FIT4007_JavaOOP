import java.util.List;

public class ProfitCalculator {

    public double calculateProfit(List<ImportOrder> imports, List<ExportOrder> exports) {
        double totalImport = imports.stream().mapToDouble(Order::getTotalAmount).sum();
        double totalExport = exports.stream().mapToDouble(Order::getTotalAmount).sum();
        return totalExport - totalImport;
    }
}
