import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterController {
    private CashRegister model;
    private RegisterView view;

    public RegisterController(CashRegister model, RegisterView view) {
        this.model = model;
        this.view = view;

        view.getScanButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleScan();
            }
        });
    }

    private void handleScan() {
        String[] product = model.scanProduct();
        if (product != null) {
            view.updateItemList(model.getScannedItems());
            view.updateSubtotal(model.getSubtotal());
        }
    }
}

