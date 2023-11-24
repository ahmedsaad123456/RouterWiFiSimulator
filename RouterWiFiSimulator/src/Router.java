import java.util.LinkedList;
import java.util.Queue;

public class Router {
    protected Semaphore semaphore;

    private Queue<Integer> availableConnections;

    //=================================================================================================================
    public Router(int maxConnections) {
        semaphore = new Semaphore(maxConnections); // Initialize with a permit for the router itself
        availableConnections = new LinkedList<>();
        // Initialize available connections queue

        for(int i = 1 ; i<=maxConnections ; i++){
            availableConnections.add(i);
        }

    }


    //=================================================================================================================

    /**
     * Connect the device to the router.
     *
     * @param device The device that needs to connect to the router.
     */
    public void connect(Device device) {

        // Check if there is an available connection

        synchronized (this) {
            if (availableConnections.size() == 0) {
                System.out.println(device.getDeviceName() + " (" + device.getType() + ")" + " arrived and waiting");
            }
            else{
                System.out.println(device.getDeviceName() + " (" + device.getType() + ")" + " arrived");
            }

        }

        // Acquire a connection permit from the semaphore
        semaphore.acquire();

        int connectionID = availableConnections.poll();  // get the connection
        device.setConnectionID(connectionID);          // give the connection to the device

        // Output connection information
        System.out.println("Connection " + connectionID + ": " + device.getDeviceName() + " Occupied");
        System.out.println("Connection " + connectionID + ": " + device.getDeviceName() + " login");
    }

    //=================================================================================================================



    /**
     * Disconnect the device from the router.
     *
     * @param device The device that needs to disconnect from the router.
     */
    public void disconnect(Device device) {

        // Output disconnection information
        System.out.println("Connection " + device.getConnectionID() + ": " + device.getDeviceName() + " logout");
        int connectionID = device.getConnectionID();  // get the connection of the device

        // Add the connection back to the available connections queue
        availableConnections.add(connectionID);

        // Release the connection permit
        semaphore.release();
    }

    //=================================================================================================================



}
