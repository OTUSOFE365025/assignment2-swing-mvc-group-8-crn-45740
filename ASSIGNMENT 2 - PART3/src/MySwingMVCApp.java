public class MySwingMVCApp {
    public static void main(String[] args) {
        CashRegister model = new CashRegister("products.txt");
        RegisterView view = new RegisterView();
        RegisterController controller = new RegisterController(model, view);
    }
}
