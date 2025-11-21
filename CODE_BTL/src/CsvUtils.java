import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvUtils {
    public static List<String[]> read(String path) {
        List<String[]> lines = new ArrayList<>();
        File file = new File(path);
        if (!file.exists()) return lines;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line.split(","));
            }
        } catch (IOException e) { e.printStackTrace(); }
        return lines;
    }

    public static void write(String path, List<String[]> data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (String[] row : data) {
                bw.write(String.join(",", row));
                bw.newLine();
            }
        } catch (IOException e) { e.printStackTrace(); }
    }
}
