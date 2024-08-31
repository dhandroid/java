package concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

    public static void main(String[] args) {

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {


            try {
                Thread.sleep(2000); //Simulate a long-running task
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


            return "Async Task Result";

        });


        System.out.println("Doing other work");

        completableFuture.thenAccept(result -> System.out.println("Result: "+result));

        // Sleep the main thread for demonstration purposes to ensure async task completion

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
