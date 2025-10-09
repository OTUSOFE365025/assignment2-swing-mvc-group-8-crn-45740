import javax.swing.*;
import java.awt.*;
import java.util.List;

public class RegisterView {
    private JFrame frame;
    private JTextArea itemList;
    private JLabel subtotalLabel;
    private JButton scanButton;

    public RegisterView() {
        frame = new JFrame("Cash Register");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        itemList = new JTextArea();
        itemList.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(itemList);

        subtotalLabel = new JLabel("Subtotal: $0.00");
        scanButton = new JButton("Scan Item");

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(scanButton, BorderLayout.WEST);
        bottomPanel.add(subtotalLabel, BorderLayout.EAST);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public void updateItemList(List<String[]> items) {
        itemList.setText("");
        for (String[] item : items) {
            itemList.append(item[1] + " - $" + item[2] + "\n");
        }
    }

    public void updateSubtotal(double subtotal) {
        subtotalLabel.setText(String.format("Subtotal: $%.2f", subtotal));
    }

    public JButton getScanButton() {
        return scanButton;
    }
}
