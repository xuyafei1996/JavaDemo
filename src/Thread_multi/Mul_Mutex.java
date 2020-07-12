package Thread_multi;
/**
 * 【线程互斥】
 *  互斥资源：票(30张)
 *  M1.使用synchronized自动加解锁(锁住范围:object)
 *  M2.使用ReentrantLock手动加解锁
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Mul_Mutex {
    public static void main(String[] args) {
        //创建SellTicket类的对象
        SellTicket1 st = new SellTicket1();
//        SellTicket2 st = new SellTicket2();
        //创建三个Thread类对象，把SellTicket对象作为构造方法的参数，并给出对应的窗口名称
        Thread t1 = new Thread(st,"窗口1");
        Thread t2 = new Thread(st,"窗口2");
        Thread t3 = new Thread(st,"窗口3");
        t1.start();
        t2.start();
        t3.start();
    }

    //M1.使用synchronized自动加解锁
    public static class SellTicket1 implements Runnable{
        private int tickets = 10;
        private Object obj = new Object();
        @Override
        public void run() {
            while (true) {
                //锁住该对象实例
                synchronized (obj){
                    if (tickets > 0) {
                        System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票");
                        tickets--;
                    }
                }
            }
        }
    }
    //M2.使用ReentrantLock手动加解锁
    public static class SellTicket2 implements Runnable{
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


}
