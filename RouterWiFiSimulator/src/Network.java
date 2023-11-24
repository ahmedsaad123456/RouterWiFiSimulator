import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Network {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to our network");
        System.out.print("What is the number of WI-FI Connections? ");
        int maxConnections = scan.nextInt();

        System.out.print("What is the number of devices Clients want to connect? ");
        int totalDevices = scan.nextInt();

        List<Device> devices = new ArrayList<>();
        Router router = new Router(maxConnections);

        for (int i = 1; i <= totalDevices; i++) {
            System.out.print("Enter the name and type of device " + i + " (e.g., C" + i + " mobile): ");
            String deviceName = scan.next();
            String deviceType = scan.next();
            devices.add(new Device(deviceName, deviceType, router));

        }


        for (Device device : devices) {
            device.start();

        }

        scan.close();


    }
}