package threads;

public class DaemonThread {
    public static void main(String[] args) {
        ThreadClass threadClass = new ThreadClass();
        threadClass.setDaemon(true);
        threadClass.start();
//        threadClass.start();
//        threadClass.run();
        for(int i=0; i<10; i++){
            System.out.println("Inside thread: "+Thread.currentThread().getName()+" count: "+i);
        }
    }

}

class ThreadClass extends Thread{
    /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see #start()
     * @see #stop()
     * @see #Thread(ThreadGroup, Runnable, String)
     */
    @Override
    public void run() {
        for(int i=0; i<1000; i++){
            System.out.println("Inside thread: "+Thread.currentThread().getName()+" count: "+i);
        }
    }
}
