package concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AllOfAndAnyOfCompletableFuture {

    private static CompletableFuture<String> service1() {
        return CompletableFuture.supplyAsync(() -> {
            simulateDelay(1000);
            return "Result From Service 1";
        });
    }

    private static CompletableFuture<String> service2(){

        return CompletableFuture.supplyAsync(() -> {

            simulateDelay(1000);

            return "Result From Service 2";
        });

    }

    private static CompletableFuture<String> service3(){

        return CompletableFuture.supplyAsync(() -> {

            simulateDelay(1000);

            return "Result From Service 2";
        });

    }

    // Simulate delay in milliseconds
    private static void simulateDelay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {


        CompletableFuture<Void> allOf = CompletableFuture.allOf(service1(),service2(),service3())
                .thenRun(() -> System.out.println("All Services Completed"));

        allOf.thenAccept(v -> {


            try{


                String result1 = service1().get();
                String result2 = service2().get();
                String result3 = service3().get();
                System.out.println("All results: " + result1 + ", " + result2 + ", " + result3);


            }catch (InterruptedException | ExecutionException e){
             e.printStackTrace();
            }

        }).handle((v, ex) -> {
            if (ex != null) {
                System.out.println("Exception occurred in allOf: " + ex.getMessage());
            }
            return null;

        });

// AnyOf example: Proceed as soon as any service completes
        CompletableFuture<Object> anyOf = CompletableFuture.anyOf(service1(), service2(), service3())
                .thenAccept(result -> System.out.println("First completed result: " + result))
                .handle((result, ex) -> {
                    if (ex != null) {
                        System.out.println("Exception occurred in anyOf: " + ex.getMessage());
                    }
                    return result;
                });

        // Ensure the main thread waits for all the above operations to complete for demo purposes
        allOf.join();
        anyOf.join();

        System.out.println("Main thread completed");


    }


}
