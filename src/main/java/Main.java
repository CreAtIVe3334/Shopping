import Exceptions.ExceptionCustomerNotfound;
import controller.*;

public class Main {
    public static void main(String[] args) throws ExceptionCustomerNotfound {
        MenuController meniuController = new MenuController();
        meniuController.menu();
    }

}
