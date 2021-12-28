package Solution13_6_4_Pizzeria;
/*
Смоделируйте работу этой пиццерии.
Как только есть свободный вагончик, он начинает работу по приготовлению и доставке, которая заканчивается через 500 ms, ведь в тестирующей системе время течет во много раз быстрее
(это можно смоделировать простой командой Thread.sleep(500)).

Как только доставка заканчивается, на консоль нужно выдать фразу:

PizzaName is delivered
После этого вагончик может немедленно начать новую доставку.

Но клиенты не любят ждать, если ожидать приходится более 15 минут (в тестирующей системе 750 ms), заказ отменяется. Для того чтобы понять, сколько клиент ждет,
можно пользоваться System.currentTimeMilllis().

В этом случае на консоль выводится надпись:

PizzaName is NOT delivered
Таким образом, на консоли появляется информация о всех заказах в порядке их обработки. Каждый заказ либо доставлен, либо нет.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Pizzeria pizzeria = new Pizzeria();
        pizzeria.order("Margarita");
        Thread.sleep(100);
        pizzeria.order("Pepperoni");
        Thread.sleep(100);
        pizzeria.order("Sicilian");
        Thread.sleep(48);
        pizzeria.order("Greek");

    }
}

/*
Например, такая программа:

public static void main(String[] args) throws InterruptedException {

    Pizzeria pizzeria = new Pizzeria();
    pizzeria.order("Margarita");
    Thread.sleep(100);
    pizzeria.order("Pepperoni");
    Thread.sleep(100);
    pizzeria.order("Sicilian");
    Thread.sleep(100);
    pizzeria.order("Greek");

}

должна вывести:

Margarita is delivered
Sicilian is NOT delivered
Greek is delivered
Pepperoni is delivered

Действительно:

1. Первый вагончик отправляется с Маргаритой и возвращается через 500ms от начала;

2. Второй вагончик отправляется с Пепперони и возвращается через 600ms от начала;

3. Заказ на Сицилианскую пиццу приходит через 200ms от начала и, чтобы его доставить, потребуется 300ms (ожидание первого вагончика) + 500 ms на доставку. То есть 800ms с момента заказа.
Долго, заказ отменяется;

4. Первый вагончик забирает заказ на греческую пиццу, потому что заказ будет доставлен через 200ms ожидания + 500ms на доставку, успеваем.


А вот такой код:

Pizzeria pizzeria = new Pizzeria();
pizzeria.order("Margarita");
Thread.sleep(500);
pizzeria.order("Pepperoni");
Thread.sleep(500);
pizzeria.order("Sicilian");
Thread.sleep(500);
pizzeria.order("Greek");

}
Доставит все заказы.
 */