import java.util.LinkedList;
import java.util.Queue;

public class Router {
    protected Semaphore semaphore;

    private Queue<Integer> availableConnections;


    // 3

    public Router(int maxConnections) {
        semaphore = new Semaphore(maxConnections); // Initialize with a permit for the router itself
        availableConnections = new LinkedList<>();
        for(int i = 1 ; i<=maxConnections ; i++){
            availableConnections.add(i);
        }

    }


    public void connect(Device device) {

        synchronized (this) {
            if (availableConnections.size() == 0) {
                System.out.println(device.getDeviceName() + " (" + device.getType() + ")" + " arrived and waiting");
            }
            else{
                System.out.println(device.getDeviceName() + " (" + device.getType() + ")" + " arrived");
            }

        }
        semaphore.acquire();

        int connectionID = availableConnections.poll();
        device.setConnectionID(connectionID);
        System.out.println("Connection " + connectionID + ": " + device.getDeviceName() + " Occupied");
        System.out.println("Connection " + connectionID + ": " + device.getDeviceName() + " login");
    }

    public void disconnect(Device device) {
        System.out.println("Connection " + device.getConnectionID() + ": " + device.getDeviceName() + " logout");
        int connectionID = device.getConnectionID();
        availableConnections.add(connectionID);
        semaphore.release();
    }


}
