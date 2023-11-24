import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Network {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to our network");

        //=================================================================================================================

        // Get the number of Wi-Fi connections from the user
        System.out.print("What is the number of WI-FI Connections? ");
        int maxConnections = scan.nextInt();

        //=================================================================================================================

        // Get the number of devices clients want to connect from the user
        System.out.print("What is the number of devices Clients want to connect? ");
        int totalDevices = scan.nextInt();

        //=================================================================================================================


        // Create a list to store devices and initialize a router with the specified number of connections
        List<Device> devices = new ArrayList<>();
        Router router = new Router(maxConnections);


        // Allow the user to enter the name and type of each device and add them to the devices list

        for (int i = 1; i <= totalDevices; i++) {
            System.out.print("Enter the name and type of device " + i + " (e.g., C" + i + " mobile): ");
            String deviceName = scan.next();
            String deviceType = scan.next();
            devices.add(new Device(deviceName, deviceType, router));

        }


        //=================================================================================================================

        // Start each device in a separate thread

        for (Device device : devices) {
            device.start();

        }

        scan.close();

        //=================================================================================================================

    }
}