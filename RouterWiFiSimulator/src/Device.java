class Device extends Thread {
    private String deviceName;
    private String type;
    private int connectionID;
    private Router router;


    public Device(String name  , String t , Router r){
        deviceName = name;
        type = t ;
        router = r;
    }

    public String getDeviceName(){
        return deviceName;
    }
    public String getType(){
        return type;
    }
    public int getConnectionID(){
        return connectionID;
    }

    public void setConnectionID(int connectionID) {
        this.connectionID = connectionID;
    }

    public Router getRouter(){
        return router;
    }
    public void run(){
        router.connect(this);
        performOnlineActivity();
        router.disconnect(this);
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
