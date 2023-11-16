public class Semaphore {
    private int value = 0 ;
    public Semaphore() { value = 0 ; }
    public Semaphore(int initial) { value = initial ; }

    /**
     * responsible for acquiring a permit,
     * and if no permit is available (value becomes negative),
     * the current thread waits until a permit is released.
     *
     * ward "synchronized" ensures that only one thread can execute
     * this method for the given instance of "Semaphore"
     *
     */
    public synchronized void P() {
        value-- ;
        if (value < 0)
            try { wait() ; } catch( InterruptedException e ) { }
    }


    /**
     *
     * responsible for releasing a permit,
     * and if there were waiting threads,
     * it notifies one of them to acquire the released permit.
     *
     *
     * ward "synchronized" ensures that only one thread can execute
     * this method for the given instance of "Semaphore"
     *
     */
    public synchronized void V() {
        value++ ;
        if (value <= 0) notify() ;
    }
}
