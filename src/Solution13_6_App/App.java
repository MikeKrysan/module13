package Solution13_6_App;

import java.util.concurrent.atomic.AtomicInteger;

public class App {
    //private int count = 0;    //1.
    //Вместо примитивного типа int мы можем объявить переменную count как ссылку на объект класса java.util.concurrent.atomic.AtomicInteger:
    private AtomicInteger count = new AtomicInteger(0); // используем новый класс AtomicInteger

//    void increment() { // синхронизируем доступ к операции`//1.
//        count++;
//    }

    public static void main(String[] args) throws InterruptedException {
        App app = new App(); // строка 1
        app.doWork();
    }

    private void doWork() throws InterruptedException {
        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    //increment();  //1.
                    count.incrementAndGet(); // атомарно увеличивает значение на 1  //2.
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    //increment();  //1.
                    count.incrementAndGet(); // атомарно увеличивает значение на 1  //2.
                }
            }
        };

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Count is: " + count); // Count is: 20000
    }
}

/*
1. Это же наш банк, только упрощенный! Выведено будет… почти что угодно, 20000 мы увидим очень редко. Потому что операция ++ — неатомарная
2.
 */