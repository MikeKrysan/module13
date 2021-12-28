package Solution13_6_Bank;

import java.util.concurrent.atomic.AtomicInteger;

public class Bank {
    private AtomicInteger money = new AtomicInteger();
    private Object lock = new Object();

    int getMoney() {
        return money.get();
    }

    void take(int money) {
        if (getMoney() >= 1000) {
            this.money.addAndGet(-money);
        }

    }

    void repay(int money) {
        this.money.addAndGet(money);
    }

    class Client extends Thread {
        @Override
        public void run() {
            while (true) {
                if (getMoney() >= 1000) {
                    take(1000);
                    repay(1000);
                }
            }
        }
    }


    public Bank() {
        money.set(10000);
        for (int i = 0; i < 5; i++) {
            new Client().start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Solution13_6_Bank.Bank bank = new Solution13_6_Bank.Bank();
        while (true) {
            System.out.println(bank.money);
            Thread.sleep(1000);
        }
    }
}
