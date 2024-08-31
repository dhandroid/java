package concurrency.thread.basics;

public class ThreadDemo {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());

        System.out.println(Runtime.getRuntime().availableProcessors());

           // Thread thread = new Thread(new DownloadFileTask());

         //   thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //thread.interrupt();

      /*  try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

        System.out.println("File is ready to be Scanned");

    }
}


class DownloadFileTask implements Runnable{

    DownloadStatus downloadStatus;
    public DownloadFileTask(DownloadStatus status) {
        this.downloadStatus = status;
    }

    @Override
    public void run() {

        System.out.println("Downloading File "+Thread.currentThread().getName());

      /*  try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
           e.printStackTrace();
        }*/

        for (int i = 0; i < 10_000; i++) {
            if (Thread.currentThread().isInterrupted()) return;
            System.out.println("Downloading Byte: "+i);

        }

        System.out.println("Download Complete: "+Thread.currentThread().getName());
    }
}
