class Device extends Thread {
    private static int nextConnectionID = 1;
    private final String deviceName;
    private final Router router;
    private int connectionID;

    public Device(String name, Router router) {
        this.deviceName = name;
        this.router = router;
        this.connectionID = -1; // No connection initially
    }
    public String getDeviceName() {
        return deviceName;
    }

    public int getConnectionID() {
        return connectionID;
    }

    @Override
    public void run() {
        try {
            router.connect(this);
            router.performOnlineActivity(this);
            router.disconnect(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void assignConnectionID() {
        connectionID = nextConnectionID++;
    }
}
