class Foo {

    private int turn = 0;

    public Foo() {
        turn = 0;
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        turn = 1;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while (turn != 1) {
            wait();
        }
        printSecond.run();
        turn = 2;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while (turn != 2) {
            wait();
        }
        printThird.run();
    }
}
