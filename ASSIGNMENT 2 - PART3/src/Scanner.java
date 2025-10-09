// This window emulates the scanning of an item. Every time the button is pressed,
// it will randomly select a UPC code from a file and display product information.

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Scanner {
    private JFrame frame;
    private JPanel scannerPanel;
    private JButton scanButton;
    private List<String[]> products; // [UPC, Product, Price]
    private Random random;

    public Scanner() {
        frame = new JFrame("Scanner");
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 150);
        frame.setLocation(300, 50);

        scanButton = new JButton("Scan");
        scannerPanel = new JPanel();
        scannerPanel.add(scanButton);
        frame.getContentPane().add(scannerPanel, BorderLayout.CENTER);
        frame.setVisible(true);

        products = loadProducts("products.txt");
        random = new Random();

        scanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRandomProduct();
            }
        });
    }

    // Reads the file containing product info
    private List<String[]> loadProducts(String filename) {
        List<String[]> productList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                productList.add(data);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return productList;
    }

    // Randomly selects a product and shows it
    private void showRandomProduct() {
        if (products.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No products found!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int index = random.nextInt(products.size());
        String[] product = products.get(index);

        String message = "UPC: " + product[0] +
                "\nProduct: " + product[1] +
                "\nPrice: $" + product[2];
        JOptionPane.showMessageDialog(frame, message, "Scanned Item", JOptionPane.INFORMATION_MESSAGE);
    }

    // Getters (optional if connecting with MVC)
    public JButton getScanButton() {
        return scanButton;
    }

    public JFrame getFrame() {
        return frame;
    }
}
