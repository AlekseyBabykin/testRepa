package lesson29;

import java.util.concurrent.Semaphore;

public class Forest {

    int value;

    public Forest(int value) {
        this.value = value;
    }

    public Forest() {
        this(50000);
    }
    public int getWood() throws InterruptedException {
        this.value -=10;
        Thread.sleep(1000);
        return 10;
    }
}
