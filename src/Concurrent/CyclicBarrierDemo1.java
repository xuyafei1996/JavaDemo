package Concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo1 {
    public static void main(String[] args) {
        //��һ��CyclicBarrierʵ��
        CyclicBarrier cb = new CyclicBarrier(4);
        new Thread(new Fishing(cb),"1").start();
        new Thread(new Fishing(cb),"2").start();
        new Thread(new Fishing(cb),"3").start();
        new Thread(new Fishing(cb),"4").start();
    }

    //��̬��
    static class Fishing implements Runnable{
        CyclicBarrier cb;
        public Fishing(CyclicBarrier cb) {
            this.cb = cb;
        }

        @Override
        public void run() {
            try {
                System.out.println("�ڣ�" + Thread.currentThread().getName() + "�����˿�ʼ����");
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("�����߳�ִ����ϣ����������������񣬱������ݲ���");
        }
    }
}