import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Solution13_6_BlockingQueue {
    public static void main(String[] args) {
        try {
            BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();

            blockingQueue.offer(39);        //1.
            blockingQueue.offer(3, 4, TimeUnit.SECONDS); // добавление с ожиданием доступного места
            // (если очередь фиксированной длины)

            System.out.println(blockingQueue.poll());   //2.
            System.out.println(blockingQueue.poll(10, TimeUnit.MILLISECONDS)); // удаление с ожиданием пока
            // требуемый элемент не станет доступным
        } catch (InterruptedException exception) {
            // обработка прерывания
        }
    }
}

/*
1. 	Добавляет элемент в очередь, если нет свободного места, то ждет определенное время и возвращает false, если время истекло.
2. Убирает из очереди и возвращает пользователю элемент, ждет определенное время, до того как элемент станет доступным, возвращает null, если время истекло.
 */