package multiThreading;
/**�������̳߳ء�
 * newCachedThreadPool���ɻ�����̳߳�
 * newFixedThreadPool���̶���Ŀ���̳߳�
 * newScheduledThreadPool�����ڻ�����ִ�е��̳߳�:
 *                         M1.executor.scheduleAtFixedRate
 *                         M2.executor.scheduleWithFixedDelay
 * newSingleThreadPool�����̵߳��̳߳�
 */

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    public static void main(String[] args) throws Exception {
        method1();
    }

    //�����ɻ����̳߳�
    public static void method1() throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            final int index = i;
            Thread.sleep(1000);
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "  " + index);
                }
            });
        }
    }

    //�����̶���Ŀ�ġ������õ��̳߳�
    public static void method2() throws InterruptedException {
        //���޸��߳�����
        ExecutorService executor = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            final int index = i;
            executor.execute(() -> {
                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "  " + index);
            });
        }
        executor.shutdown();
    }

    //����һ�������̳߳أ��ɰ����ڸ����ӳٺ�(��ʱ)�������ڵ�ִ������
    //M1.����һ����ʼ��ʱ���ʱ��periodʱ���ȥ��
    //   �����һ�������Ƿ�ִ����ϣ������ǰ��������ִ�У�����ȴ�
    public static void method3() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                long start = new Date().getTime();
                System.out.println("scheduleAtFixedRate ��ʼִ��ʱ��:" + DateFormat.getTimeInstance().format(new Date()));
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long end = new Date().getTime();
                System.out.println("scheduleAtFixedRate ִ�л���ʱ��=" + (end - start) / 1000 + "m");
                System.out.println("scheduleAtFixedRate ִ�����ʱ�䣺" + DateFormat.getTimeInstance().format(new Date()));
                System.out.println("======================================");
            }
        }, 1, 5, TimeUnit.SECONDS);
    }
    //M2.����һ���������ʱ��ʼ��ʱ��periodʱ���ȥ������ִ��
    public static void method4() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        executor.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                long start = new Date().getTime();
                System.out.println("scheduleWithFixedDelay ��ʼִ��ʱ��:" +
                        DateFormat.getTimeInstance().format(new Date()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long end = new Date().getTime();
                System.out.println("scheduleWithFixedDelayִ�л���ʱ��=" + (end - start) / 1000 + "m");
                System.out.println("scheduleWithFixedDelayִ�����ʱ�䣺"
                        + DateFormat.getTimeInstance().format(new Date()));
                System.out.println("======================================");
            }
        }, 1, 2, TimeUnit.SECONDS);
    }

    //����һ�����̻߳����̳߳�
    public static void method5() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {

            final int index = i;
            executor.execute(() -> {
                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "   " + index);
            });
        }
        executor.shutdown();
    }

}