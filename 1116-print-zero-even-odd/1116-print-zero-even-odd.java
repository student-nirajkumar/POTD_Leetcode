class ZeroEvenOdd {
    private int n;

    private final Object lock = new Object();
    private int turn; // 0 -> zero, 1 -> odd, 2 -> even
    private int i;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.turn = 0;
        this.i = 1;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(java.util.function.IntConsumer printNumber) throws InterruptedException {
        while (i <= n) {
            synchronized (lock) {
                while (turn != 0 && i <= n) {
                    lock.wait();
                }
                if (i > n) {
                    break;
                }
                printNumber.accept(0);
                turn = (i % 2 == 0) ? 2 : 1;
                lock.notifyAll();
            }
        }
    }

    public void even(java.util.function.IntConsumer printNumber) throws InterruptedException {
        while (i <= n) {
            synchronized (lock) {
                while (turn != 2 && i <= n) {
                    lock.wait();
                }
                if (i > n) {
                    break;
                }
                printNumber.accept(i++);
                turn = 0;
                lock.notifyAll();
            }
        }
    }

    public void odd(java.util.function.IntConsumer printNumber) throws InterruptedException {
        while (i <= n) {
            synchronized (lock) {
                while (turn != 1 && i <= n) {
                    lock.wait();
                }
                if (i > n) {
                    break;
                }
                printNumber.accept(i++);
                turn = 0;
                lock.notifyAll();
            }
        }
    }
}
