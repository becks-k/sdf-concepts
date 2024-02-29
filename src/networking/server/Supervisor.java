package server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class Supervisor implements Runnable {

    private final ThreadPoolExecutor threadPoolExecutor;
    private final int interval;

    @Override
    public void run() {
        if (threadPoolExecutor != null) {
            do {
                System.out.println("#### Thread report: Active: " + threadPoolExecutor.getActiveCount() + " Pool size: " + threadPoolExecutor.getPoolSize() + " Max Pool: " + threadPoolExecutor.getMaximumPoolSize() + " #####");
                try {
                    Thread.sleep(interval);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } while (threadPoolExecutor.getActiveCount() > 1);
        }

    }

    public Supervisor(ExecutorService executorService, int interval) {

        this.interval = interval;
        if (executorService instanceof ThreadPoolExecutor) {
            threadPoolExecutor = (ThreadPoolExecutor) executorService;
        } else {
            threadPoolExecutor = null;
            System.out.println("This executor does not support ThreadPoolExecutor.");
        }

    }

}
