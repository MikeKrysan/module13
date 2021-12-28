package Solution13_7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/*
Создать пул из двух потоков. В цикле добавить в пул 5 потоков с задержкой 4 с. Вывести результат их работы в консоль.
 */
public class ThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);  //1

        for (int i = 0; i < 5; i++) {
            executorService.submit(new Work(i));

            executorService.shutdown();
            System.out.println("All tasks submitted");
        }
    }
}

class Work implements Runnable {
    public int id;

    public Work(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Work " + id + " was completed");
    }
}


/*
1. https://habr.com/ru/post/554608/
Эффекты согласованности памяти: действия в потоке перед отправкой задачи Runnable или Callable в ExecutorService происходят - до любых действий,
предпринятых этой задачей, которые, в свою очередь, происходят - до того, как результат будет получен через Future.get ().

newFixedThreadPool() - Создает пул потоков, который повторно использует фиксированное количество потоков, работающих в общей неограниченной очереди.
 */