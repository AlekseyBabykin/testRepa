package lesson29;

import java.util.concurrent.Semaphore;

public class Employees implements Runnable {
    Camp camp;
    Forest forest;
    Semaphore sem;
    private int stamina;
    private int resourse;



    public Employees(Camp camp, Forest forest, Semaphore sem) {
        this.camp = camp;
        this.forest = forest;
        this.sem = sem;
        this.stamina = 5;
        this.resourse = 0;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(forest + " доступ к лесу");
                sem.acquire();
                this.resourse = this.forest.getWood();
                this.camp.addWood(this.resourse);
                System.out.println(forest + " получил доступ  к лесу");
//            cam.y =;
//            for (int i = 0; i < 3; i++) {
                //System.out.println(this.forest + ": " + cam.y);
                camp.value++;
//                Thread.sleep(150);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(this.camp + " в лагере");
        sem.release();
    }
}
