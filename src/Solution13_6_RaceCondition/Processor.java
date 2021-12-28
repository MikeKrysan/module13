package Solution13_6_RaceCondition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Processor implements Runnable{
    private int elem;

    public Processor(int elem) {
        this.elem = elem;
    }

    @Override
    public void run() {
        Main.set.put("Key" + elem, 12); //put() - 1.
    }
}

class AnotherProcessor implements Runnable {

    private int elem;

    public AnotherProcessor(int elem) {
        this.elem = elem;
    }

    @Override
    public void run() {
        Main.set.remove("Key" + elem);  //2.
    }
}

class Main {

    static Map<String, Integer> set = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            new Thread(new Processor(i)).start();
            new Thread(new AnotherProcessor(i)).start();
        }

        Thread.sleep(1000); // хватит для готового результата

        System.out.println(set);
    }

}

/*
{Key2=12, Key5=12, Key3=12, Key9=12, Key8=12, Key7=12} - как один из примеров
Результат в консоли не определен до запуска, race condition не происходит (данные не сломаны)

1. Связывает указанное значение с указанным ключом на этой карте (необязательная операция).
Если карта ранее содержала сопоставление для ключа, старое значение заменяется указанным значением. (Считается, что карта m содержит отображение для ключа k тогда и только тогда,
когда m.containsKey (k) вернет true.)

2. Удаляет сопоставление для ключа с этой карты, если оно присутствует (необязательная операция). Более формально, если эта карта содержит отображение ключа k в значение v такое,
что Objects.equals (key, k), это отображение удаляется. (Карта может содержать не более одного такого сопоставления.)
 */