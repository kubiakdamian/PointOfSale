package device;

import model.Product;

import java.math.BigDecimal;

public class LcdDisplay {
    public void print(Product product) {
        System.out.println(product.getName() + " " + product.getPrice() + "zł" + "\n");
    }

    public void print(BigDecimal sum) {
        System.out.println("SUM: " + sum + "zł" + "\n");
    }

    void print(String message) {
        System.out.println(message + "\n");
    }
}
