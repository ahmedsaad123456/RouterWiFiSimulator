class Device extends Thread {
    private String deviceName;
    private String type;
    private int connectionID;
    private Router router;

    public String getDeviceName(){
        return deviceName;
    }
    public String getType(){
        return type;
    }
    public int getConnectionID(){
        return connectionID;
    }
    public Router getRouter(){
        return router;
    }
    public void run(){
       router.arrived(this);
       router.semaphore.wait(this);
       connectionID = router.connect(this);
       System.out.println("Connection " + connectionID + ": " + deviceName + " Occupied");
       performOnlineActivity();
       router.disconnect(this);
       router.semaphore.signal();
    }
    public void performOnlineActivity(){
        try{
            System.out.println("Connection " + connectionID + ": " + deviceName + " Performs online activity");
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}
