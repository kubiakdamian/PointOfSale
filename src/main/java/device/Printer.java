package device;

import model.Product;
import system.DeviceSystem;

import java.math.BigDecimal;

public class Printer {
    public void print(BigDecimal sum) {
        for (Product product : DeviceSystem.getScannedProducts()) {
            System.out.println(product.getName() + " " + product.getPrice() + "zł");
        }
        System.out.println("SUM: " + sum + "zł" + "\n");
    }
}
