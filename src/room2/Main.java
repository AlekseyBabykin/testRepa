package room2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
    public static void main(String[] args) {

        String data = "";
        String[] names;
        try(FileInputStream fis = new FileInputStream("src/room2/name.txt")) {
            byte[] bdata = new byte[fis.available()];
            bdata = fis.readAllBytes();
            data = new String(bdata);

            System.out.println(bdata);
            System.out.println(data);
            names = data.split("\n");
            for (int i = 0; i < names.length; i++) {
                System.out.println(i + " : " + names[i]);

            }

        } catch (IOException e){
            throw  new RuntimeException(e);
        }

        Random random = new Random();
        ArrayList<Unit> nameEnd = new ArrayList<>();
        ArrayList<Unit> units = new ArrayList<>();
        units.add(new King(getRandom(names)));
        for (int i = 0; i < 10; i++) {
            units.add(new Nobel((getRandom(names))));
        }
        for (int i = 0; i < 25; i++) {
            units.add(new Knight((getRandom(names))));
        }
        for (int i = 0; i < 100; i++) {
            units.add(new Peasant((getRandom(names))));
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("Day: " + (i + 1));
            for (int j = 0; j < units.size(); j++) {
                Unit current = units.get(j);
                if (current.isAlive()) {
                    current.getDamage(random.nextInt(15));
                    current.status();
                   // nameEnd.add()
                } else {
                    System.out.println("Dead :( ");
                    current.status();
                }
            }
        }
        int counter = 0;
        for (Unit u : units) {
            if (!u.isAlive()) {
                counter++;
            }
        }
        System.out.println("We have " + counter + " dead people after this plague");



    }
}
