import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Solution13_6_LinkedBlockingQueue {
    public static void main(String[] args) {
        try {
            BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>();
            blockingDeque.offer(91);
            blockingDeque.offerFirst(5, 2, TimeUnit.MINUTES); // добавление в начало с ожиданием доступного места
            // (если очередь фиксированной длины)
            blockingDeque.offerLast(47, 100, TimeUnit.MICROSECONDS); // добавление в конец с ожиданием доступного места
            // (если очередь фиксированной длины)
            blockingDeque.offer(3, 4, TimeUnit.SECONDS); // добавление в конец с ожиданием доступного места
            // (если очередь фиксированной длины)

            System.out.println(blockingDeque.poll());
            System.out.println(blockingDeque.poll(950, TimeUnit.MILLISECONDS)); // удаление с начала с ожиданием пока
            // требуемый элемент не станет доступным
            System.out.println(blockingDeque.pollFirst(200, TimeUnit.NANOSECONDS)); // удаление с начала с ожиданием пока
            // требуемый элемент не станет доступным
            System.out.println(blockingDeque.pollLast(1, TimeUnit.SECONDS)); // удаление с конца с ожиданием пока
            // требуемый элемент не станет доступным
        } catch (InterruptedException exception) {
            // обработка прерывания
        }
    }
}
