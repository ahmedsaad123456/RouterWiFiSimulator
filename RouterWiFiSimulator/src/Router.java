import java.util.concurrent.Semaphore;

public class Router {
    protected Semaphore semaphore;
    private int nextConnectionID;

    public Router() {
        semaphore = new Semaphore(1); // Initialize with a permit for the router itself
        nextConnectionID = 1; // Start connection IDs from 1
    }

    public void arrived(Device device) {
        System.out.println('(' + device.getDeviceName() + ')' + '(' + device.getType() + ')' + " arrived");
    }


    public int connect(Device device) {
        int connectionID = getNextConnectionID();
        System.out.println("Connection " + connectionID + ": " + device.getDeviceName() + " login");
        return connectionID;
    }

    public void disconnect(Device device) {
        int connectionID = device.getConnectionID();
        System.out.println("Connection " + connectionID + ": " + device.getDeviceName() + " logout");
    }

    private synchronized int getNextConnectionID() {
        return nextConnectionID++;
    }

//
//    public void setNextConnectionID(int nextConnectionID) {
//        this.nextConnectionID = nextConnectionID;
//    }
//
//    public void setSemaphore(Semaphore semaphore) {
//        this.semaphore = semaphore;
//    }
//    public Semaphore getSemaphore() {
//        return semaphore;
//    }
}
