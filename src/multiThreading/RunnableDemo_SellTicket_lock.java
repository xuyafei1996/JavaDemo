package multiThreading;

import java.util.Locale;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableDemo_SellTicket_lock {
    public static class SellTicket implements Runnable{
        private int tickets = 10;
        private Lock lock = new ReentrantLock();
        @Override
        public void run() {
            while (true) {
                lock.lock();
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票");
                    tickets--;
                }
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        //创建SellTicket类的对象
        SellTicket st = new SellTicket();
        //创建三个Thread类对象，把SellTicket对象作为构造方法的参数，并给出对应的窗口名称
        Thread t1 = new Thread(st,"窗口1");
        Thread t2 = new Thread(st,"窗口2");
        Thread t3 = new Thread(st,"窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
