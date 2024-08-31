package concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;

public class HandleCompletable {


    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            if (1!=1) {
                throw new RuntimeException("Something went wrong!");
            }
            return "Success!";
        }).handle((result, ex) -> {
            if (ex != null) {
                System.out.println("Exception: " + ex.getMessage());
                return "Fallback result";
            } else {
                return result.toLowerCase();
            }
        });


        future.thenAccept(System.out::println);
    }
}
