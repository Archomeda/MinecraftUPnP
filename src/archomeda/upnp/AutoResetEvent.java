package archomeda.upnp;

public class AutoResetEvent {
    private final Object monitor = new Object();
    private volatile boolean state = false;

    /**
     * Creates an automatic reset event, which can be used to synchronize statements for thread safety.
     * 
     * @param initialState
     *            The initial state of this reset event.
     */
    public AutoResetEvent(boolean initialState) {
        state = initialState;
    }

    /**
     * Blocks the current thread until another thread calls set().
     */
    public void waitOne() {
        try {
            waitOneChecked();
        } catch (InterruptedException e) {
        }
    }

    /**
     * Blocks the current thread until another thread calls set(). This variant may throw an InterruptedException.
     * 
     * @throws InterruptedException
     *             This exception will be thrown when a thread interrupted the current thread before the wait was over.
     */
    public void waitOneChecked() throws InterruptedException {
        synchronized (monitor) {
            while (!state) {
                monitor.wait();
            }
            state = false;
        }
    }

    /**
     * Signals the reset event so that a blocked thread that called waitOne() or waitOneChecked() may resume.
     */
    public void set() {
        synchronized (monitor) {
            state = true;
            monitor.notify();
        }
    }

    /**
     * Resets the reset event.
     */
    public void reset() {
        state = false;
    }
}
