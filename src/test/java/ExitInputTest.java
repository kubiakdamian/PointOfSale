import device.BarCodeScanner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import system.DeviceSystem;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ExitInputTest {
    private static DeviceSystem deviceSystem;
    private static BarCodeScanner barCodeScanner;
    private static ByteArrayOutputStream outContent;

    @BeforeAll
    static void setup() {
        deviceSystem = new DeviceSystem();
        barCodeScanner = new BarCodeScanner();

        DeviceSystem.getScannedProducts().clear();

        barCodeScanner.scan("874323904377");
        barCodeScanner.scan("325678548859");
        barCodeScanner.scan("423993849884");

        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }


    @Test
    void exitInputShouldPrintAllScannedProductsAndSum() {
        outContent.reset();
        deviceSystem.exit();

        assertEquals(("Pepper 2.49zł\n" +
                        "Car Toy 15zł\n" +
                        "Sugar 3zł\n" +
                        "SUM: 20.49zł\n" +
                        "\n" +
                        "SUM: 20.49zł").replaceAll("\n", "").replaceAll("\r", ""),
                outContent.toString().replaceAll("\n", "").replaceAll("\r", ""));
    }

    @Test
    void exitInputShouldClearScannedProductsArray() {
        DeviceSystem.getScannedProducts().clear();

        barCodeScanner.scan("874323904377");
        barCodeScanner.scan("325678548859");
        barCodeScanner.scan("423993849884");

        deviceSystem.exit();

        assertTrue(DeviceSystem.getScannedProducts().isEmpty());
    }
}
