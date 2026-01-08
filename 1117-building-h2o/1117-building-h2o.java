class H2O {

    private final Object lock = new Object();
    private int turn;   // counts how many H have been released

    public H2O() {
        turn = 0;
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        synchronized (lock) {
            while (turn == 2) {
                lock.wait();
            }
            releaseHydrogen.run();
            turn++;
            lock.notifyAll();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        synchronized (lock) {
            while (turn < 2) {
                lock.wait();
            }
            releaseOxygen.run();
            turn = 0;
            lock.notifyAll();
        }
    }
}
