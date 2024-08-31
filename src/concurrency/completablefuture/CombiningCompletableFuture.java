package concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;

public class CombiningCompletableFuture {

    public static void main(String[] args) {

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync( () -> 20);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync( () -> 40);

        CompletableFuture<Integer> combinedFuture = future1.thenCombine(future2,(a,b) -> a+b);

        combinedFuture.thenAccept(result -> System.out.println("Combined Result "+result));




        // Sleep the main thread for demonstration purposes to ensure async task completion
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
