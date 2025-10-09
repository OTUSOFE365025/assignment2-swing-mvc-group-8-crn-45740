import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CashRegister {
    private List<String[]> allProducts; // UPC, Name, Price
    private List<String[]> scannedItems; // Scanned products

    public CashRegister(String fileName) {
        allProducts = loadProducts(fileName);
        scannedItems = new ArrayList<>();
    }

    private List<String[]> loadProducts(String filename) {
        List<String[]> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                list.add(data);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return list;
    }

    public String[] scanProduct() {
        if (allProducts.isEmpty()) return null;
        Random rand = new Random();
        String[] product = allProducts.get(rand.nextInt(allProducts.size()));
        scannedItems.add(product);
        return product;
    }

    public double getSubtotal() {
        double sum = 0;
        for (String[] item : scannedItems) {
            sum += Double.parseDouble(item[2]);
        }
        return sum;
    }

    public List<String[]> getScannedItems() {
        return scannedItems;
    }
}
