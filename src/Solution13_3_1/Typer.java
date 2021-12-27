package Solution13_3_1;

import java.util.ArrayList;
import java.util.List;
/*
Можно синхронизироваться, например, по созданному для этого статическому
объекту класса:

 */
public class Typer extends Thread {

    static Object lock = new Object();
    String message;

    public Typer(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        synchronized (lock) {
            for (int i = 0; i < message.length(); i++) {
                System.out.print(message.charAt(i));
                try{
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}
