package service;

import model.Product;
import system.DeviceSystem;

import java.util.Optional;

public class ProductService {
    public Optional<Product> findByBarCode(String barCode) {
        for (Product product : DeviceSystem.getProducts()) {
            if (product.getBarCode().equals(barCode)) {
                return Optional.of(product);
            }
        }

        return Optional.empty();
    }
}
