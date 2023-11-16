class Device extends Thread {
    public String name;
    public String type;
    public int connectionID;
    public Router router;

    public Device(String name, String type, Router router) {
        this.name = name;
        this.type = type;
        this.router = router;
        connectionID = 1;
    }

    @Override
    public void run() {
        try {
            router.arrived(this);
            System.out.println("Connection " + connectionID + ": " + name + " Occupied");
            System.out.println("Connection " + connectionID + ": " + name + " login");
            Thread.sleep(2000);
            router.left(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
