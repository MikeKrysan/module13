package Solution13_0;
/*
Загрузка изображений оформлена в виде класса LoadingThread подкласса Thread (в тестирующей системе он скрыт).
Сразу после загрузки изображения должны быть показаны. Запустите поток LoadingThread на выполнение и после его окончания сразу выведите фразу Images are loaded.


 */
public class Main {
    public static void main(String[] args)  {
       Thread t = new LoadingThread();
       t.start();
       try {
           t.join();    //Waits for this thread to die.
       } catch(InterruptedException e) {
           System.out.println("Images are loaded");
       }
    }
}
