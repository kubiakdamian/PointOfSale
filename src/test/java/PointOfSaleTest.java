import device.BarCodeScanner;
import model.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.ProductService;
import system.DeviceSystem;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PointOfSaleTest {

    private static DeviceSystem deviceSystem;
    private static BarCodeScanner barCodeScanner;
    private static ByteArrayOutputStream outContent;
    private static ProductService productService;

    @BeforeAll
    static void setup() {
        deviceSystem = new DeviceSystem();
        barCodeScanner = new BarCodeScanner();
        productService = new ProductService();
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void systemShouldContainProducts() {
        assertTrue(DeviceSystem.PRODUCTS.size() > 0);
    }

    @Test
    void scanningProductShouldPrintItsData() {
        outContent.reset();
        barCodeScanner.scan("874323904377");

        assertEquals("Pepper 2.49zł", outContent.toString().trim());
    }

    @Test
    void productShouldBeFoundByItsBarCode() {
        Optional<Product> product = productService.findByBarCode("298754923999");

        Product testProduct = new Product("Coffee", BigDecimal.valueOf(7.79), "298754923999");

        assertEquals(testProduct, product.get());
    }

    @Test
    void scanningProductShouldAddItToScannedProducts() {
        DeviceSystem.SCANNED_PRODUCTS.clear();
        Optional<Product> product = productService.findByBarCode("298754923999");

        barCodeScanner.scan("298754923999");

        assertTrue(DeviceSystem.SCANNED_PRODUCTS.contains(product.get()));
    }

    @Test
    void scanningProductWithEmptyBarCodeShouldPrintProperData() {
        outContent.reset();
        barCodeScanner.scan("");

        assertEquals("Invalid bar-code", outContent.toString().trim());
    }

    @Test
    void scanningProductWithInvalidBarCodeShouldPrintProperData() {
        outContent.reset();
        barCodeScanner.scan("12345");

        assertEquals("Product not found", outContent.toString().trim());
    }

    @Test
    void deviceSystemShouldCalculateSumOfPurchasedProducts() {
        DeviceSystem.SCANNED_PRODUCTS.clear();

        barCodeScanner.scan("874323904377");
        barCodeScanner.scan("947363465632");
        barCodeScanner.scan("189432785434");

        assertEquals(BigDecimal.valueOf(5.93), deviceSystem.calculateSumOfProducts());
    }
}