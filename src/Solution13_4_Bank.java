

public class Solution13_4_Bank {
    private static Integer money = 10000;   //1


    int getMoney() {
        return money;
    }

    static void take(int money) {
        synchronized (Solution13_4_Bank.money) {
            Solution13_4_Bank.money -= money;
        }

    }

    static void repay(int money) {
        synchronized (Solution13_4_Bank.money) {
            Solution13_4_Bank.money += money;
        }
    }

    static class Client extends Thread{
        @Override
        public void run() {
            while(true) {
                take(1000);
                repay(1000);
            }
        }
    }



    public static void main(String[] args) throws InterruptedException {
        new Client().start();
        new Client().start();
        new Client().start();
        while(true){
            System.out.println(Solution13_4_Bank.money);
            Thread.sleep(1000);
        }
    }

}

/*
1ю cделали переменную money объектом и синхронизируемся по нему
Код скомпилируется, но будет неправильно работать, так как никакой синхронизации нет.
Integer — immutable класс. И при изменении money на самом деле создается новый объект,
и «синхронизация» происходит уже по новому объекту, то есть фактически никакой синхронизации нет.
 */