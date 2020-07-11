package Concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        //����ֵcount=2
        final CountDownLatch latch = new CountDownLatch(2);
        System.out.println("���߳̿�ʼִ�С��� ����");
        //��һ�����߳�ִ��
        ExecutorService es1 = Executors.newSingleThreadExecutor();
        es1.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("���̣߳�"+Thread.currentThread().getName()+"ִ��");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //��¼һ�����������
                latch.countDown();
            }
        });
        es1.shutdown();

        //�ڶ������߳�ִ��
        ExecutorService es2 = Executors.newSingleThreadExecutor();
        es2.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("���̣߳�"+Thread.currentThread().getName()+"ִ��");
                //��¼��һ�����������
                latch.countDown();
            }
        });
        es2.shutdown();
        System.out.println("�ȴ������߳�ִ����ϡ��� ����");

        //����await()�������̻߳ᱻ��������ȴ�ֱ��countֵΪ0�ż���ִ��
        latch.await();
        System.out.println("�������̶߳�ִ����ϣ�����ִ�����߳�");
    }
}