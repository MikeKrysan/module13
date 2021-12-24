package Solution13_1;

public class Bank {

   private int money = 10000;

    public int getMoney() {
        return money;
    }

    void take(int money) {
        this.money -= money;
    }

    void repay(int money) {
        this.money += money;
    }

    class Client extends Thread{
        @Override
        public void run() {
            while(true) {
                take(1000);
                repay(1000);
            }
        }
    }

    public Bank() {
        new Client().start();
        new Client().start();
        new Client().start();
    }

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        while(true){
            System.out.println(bank.getMoney());
            Thread.sleep(1000);
        }
    }

}
