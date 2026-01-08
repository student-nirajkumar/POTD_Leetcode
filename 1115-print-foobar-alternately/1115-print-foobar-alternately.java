class FooBar {
    private int n;

    private final Object lock = new Object();
    private int turn; // 0 -> foo, 1 -> bar

    public FooBar(int n) {
        this.n = n;
        this.turn = 0;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (turn == 1) {
                    lock.wait();
                }
                printFoo.run();
                turn = 1;
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (turn == 0) {
                    lock.wait();
                }
                printBar.run();
                turn = 0;
                lock.notifyAll();
            }
        }
    }
}
