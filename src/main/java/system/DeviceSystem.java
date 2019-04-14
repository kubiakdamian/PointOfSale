package system;

import device.LcdDisplay;
import device.Printer;
import lombok.Getter;
import model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;

@Getter
public class DeviceSystem {
    private static ArrayList<Product> products = new ArrayList<>();
    private static ArrayList<Product> scannedProducts = new ArrayList<>();

    private final LcdDisplay lcdDisplay;
    private final Printer printer;

    public DeviceSystem() {
        lcdDisplay = new LcdDisplay();
        printer = new Printer();
        createSampleProducts();
    }

    public void productScanned(Product product) {
        lcdDisplay.print(product);

        scannedProducts.add(product);
    }

    public void exit() {
        BigDecimal sum = calculateSumOfProducts();

        printer.print(sum);
        lcdDisplay.print(sum);

        scannedProducts.clear();
    }

    public BigDecimal calculateSumOfProducts() {
        BigDecimal price = new BigDecimal(0);

        for (Product product : DeviceSystem.scannedProducts) {
            price = price.add(product.getPrice());
        }

        return price;
    }

    private static void createSampleProducts() {
        products.add(new Product("Pepper", BigDecimal.valueOf(2.49), "874323904377"));
        products.add(new Product("Lemon", BigDecimal.valueOf(1.49), "234645645654"));
        products.add(new Product("Car Toy", BigDecimal.valueOf(15), "325678548859"));
        products.add(new Product("Coffee", BigDecimal.valueOf(7.79), "298754923999"));
        products.add(new Product("Tea", BigDecimal.valueOf(3.19), "947363465632"));
        products.add(new Product("Sugar", BigDecimal.valueOf(3), "423993849884"));
        products.add(new Product("Bread", BigDecimal.valueOf(1.95), "794584378673"));
        products.add(new Product("Kaiser roll", BigDecimal.valueOf(0.25), "189432785434"));
        products.add(new Product("Salad", BigDecimal.valueOf(2.99), "8237643673476"));
        products.add(new Product("Newspaper", BigDecimal.valueOf(4.99), "784387347843"));
    }

    public static ArrayList<Product> getProducts() {
        return products;
    }

    public static ArrayList<Product> getScannedProducts() {
        return scannedProducts;
    }
}
