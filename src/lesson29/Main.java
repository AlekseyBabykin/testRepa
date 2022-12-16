package lesson29;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Camp camp = new Camp();
        Forest forest = new Forest();
        Semaphore semaphore = new Semaphore(3);
        Thread[] threads = new Thread[10];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Employees(camp, forest, semaphore));
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        System.out.println(",djfvjkdfhsfhmbvjxcvbjhvbjsfkhjsfjksf");
    }
}
