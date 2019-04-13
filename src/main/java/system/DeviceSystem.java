package system;

import device.LcdDisplay;
import lombok.Getter;
import model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;

@Getter
public class DeviceSystem {
    public static ArrayList<Product> PRODUCTS;
    public static ArrayList<Product> SCANNED_PRODUCTS;
    private final LcdDisplay lcdDisplay;

    public DeviceSystem() {
        PRODUCTS = new ArrayList<>();
        SCANNED_PRODUCTS = new ArrayList<>();
        lcdDisplay = new LcdDisplay();
        createSampleProducts();
    }

    public void productScanned(Product product) {
        lcdDisplay.print(product);

        SCANNED_PRODUCTS.add(product);
    }

    private static void createSampleProducts() {
        PRODUCTS.add(new Product("Pepper", BigDecimal.valueOf(2.49), "874323904377"));
        PRODUCTS.add(new Product("Lemon", BigDecimal.valueOf(1.49), "234645645654"));
        PRODUCTS.add(new Product("Car Toy", BigDecimal.valueOf(15), "325678548859"));
        PRODUCTS.add(new Product("Coffee", BigDecimal.valueOf(7.79), "298754923999"));
        PRODUCTS.add(new Product("Tea", BigDecimal.valueOf(3.19), "947363465632"));
        PRODUCTS.add(new Product("Sugar", BigDecimal.valueOf(3), "423993849884"));
        PRODUCTS.add(new Product("Bread", BigDecimal.valueOf(1.95), "794584378673"));
        PRODUCTS.add(new Product("Kaiser roll", BigDecimal.valueOf(0.25), "189432785434"));
        PRODUCTS.add(new Product("Salad", BigDecimal.valueOf(2.99), "8237643673476"));
        PRODUCTS.add(new Product("Newspaper", BigDecimal.valueOf(4.99), "784387347843"));
    }
}
