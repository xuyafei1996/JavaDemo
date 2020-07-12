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
                    System.out.println(Thread.currentThread().getName() + "���ڳ��۵�" + tickets + "��Ʊ");
                    tickets--;
                }
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        //����SellTicket��Ķ���
        SellTicket st = new SellTicket();
        //��������Thread����󣬰�SellTicket������Ϊ���췽���Ĳ�������������Ӧ�Ĵ�������
        Thread t1 = new Thread(st,"����1");
        Thread t2 = new Thread(st,"����2");
        Thread t3 = new Thread(st,"����3");
        t1.start();
        t2.start();
        t3.start();
    }
}