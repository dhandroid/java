package concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureChainingAndCombining {
    public static void main(String[] args) {


        CompletableFuture.supplyAsync(() -> "Hello")
                .thenApply(greeting -> greeting+ " , World")
                .thenAccept(System.out::println)
                .thenRun(()->System.out.println("Done"));


        // Sleep the main thread for demonstration purposes to ensure async task completion
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
}
}
