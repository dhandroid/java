package concurrency.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleExecutor {


    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);


        scheduledExecutorService.schedule( () -> {
            System.out.println("Task Executed After 2 Seconds");
        },2, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate( () -> {
            System.out.println("Task Executed Every 2 Seconds");

        },1,2,TimeUnit.SECONDS);


        // Schedule the executor to shut down after 10 seconds
        scheduledExecutorService.schedule(() -> {

            System.out.println("Shutting down scheduler");
            scheduledExecutorService.shutdown();
        },10,TimeUnit.SECONDS);
    }
}
