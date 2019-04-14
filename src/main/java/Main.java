import device.BarCodeScanner;
import system.DeviceSystem;

public class Main {
    public static void main(String[] args) {
        //Sample action
        DeviceSystem deviceSystem = new DeviceSystem();
        BarCodeScanner barCodeScanner = new BarCodeScanner();

        barCodeScanner.scan("874323904377");
        barCodeScanner.scan("325678548859");
        barCodeScanner.scan("423993849884");
        barCodeScanner.scan("23904377");
        barCodeScanner.scan("");

        deviceSystem.exit();
    }
}
