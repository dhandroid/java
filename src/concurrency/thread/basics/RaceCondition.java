package concurrency.thread.basics;

public class RaceCondition {

    public static void main(String[] args) {


        var status = new DownloadStatus();

        for (int i = 0; i <10 ; i++) {

            var thread = new Thread(new DownloadFileTask(status));
            thread.start();
        }
    }
}


class DownloadStatus{


    private int totalBytes;

    public int getTotalBytes() {
        return totalBytes;
    }

    public void incrementTotalBytes(){

        totalBytes++;
    }
}