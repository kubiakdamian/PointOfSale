package device;

import model.Product;
import service.ProductService;
import system.DeviceSystem;

import java.util.Optional;

public class BarCodeScanner {

    private final ProductService productService;
    private final DeviceSystem deviceSystem;

    public BarCodeScanner() {
        deviceSystem = new DeviceSystem();
        productService = new ProductService();
    }

    public void scan(String barCode) {
        if (barCode.equals("")) {
            deviceSystem.getLcdDisplay().print("Invalid bar-code");
            return;
        }

        Optional<Product> product = productService.findByBarCode(barCode);

        if (product.isPresent()) {
            deviceSystem.productScanned(product.get());
        } else {
            deviceSystem.getLcdDisplay().print("Product not found");
        }
    }
}
