package Solution13_3_2;

import java.util.HashSet;
import java.util.Set;

public class Main {
    private Set<String> intSet = new HashSet<>();

    private synchronized void addElemToSet() {
        intSet.add("Hello");
    }

    private synchronized void removeElemToSet() {
        intSet.remove("Hello");
    }

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();

        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    main.addElemToSet();
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {


                main.removeElemToSet();
            }
        };

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Set size: " + main.intSet.size());
    }
}
