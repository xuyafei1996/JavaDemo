package Thread_multi;
/**
 * ���̻߳��⡿
 *  ������Դ��Ʊ(30��)
 *  M1.ʹ��synchronized�Զ��ӽ���(��ס��Χ:object)
 *  M2.ʹ��ReentrantLock�ֶ��ӽ���
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Mul_Mutex {
    public static void main(String[] args) {
        //����SellTicket��Ķ���
        SellTicket1 st = new SellTicket1();
//        SellTicket2 st = new SellTicket2();
        //��������Thread����󣬰�SellTicket������Ϊ���췽���Ĳ�������������Ӧ�Ĵ�������
        Thread t1 = new Thread(st,"����1");
        Thread t2 = new Thread(st,"����2");
        Thread t3 = new Thread(st,"����3");
        t1.start();
        t2.start();
        t3.start();
    }

    //M1.ʹ��synchronized�Զ��ӽ���
    public static class SellTicket1 implements Runnable{
        private int tickets = 10;
        private Object obj = new Object();
        @Override
        public void run() {
            while (true) {
                //��ס�ö���ʵ��
                synchronized (obj){
                    if (tickets > 0) {
                        System.out.println(Thread.currentThread().getName() + "���ڳ��۵�" + tickets + "��Ʊ");
                        tickets--;
                    }
                }
            }
        }
    }
    //M2.ʹ��ReentrantLock�ֶ��ӽ���
    public static class SellTicket2 implements Runnable{
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


}