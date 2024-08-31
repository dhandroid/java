package concurrency.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsDemo {

    public static void main(String[] args) {


        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10 ; i++) {

            executorService.submit(() -> System.out.println("task Executed Successfully By:  "+Thread.currentThread().getName()));
        }


        executorService.shutdown();

    }
}
