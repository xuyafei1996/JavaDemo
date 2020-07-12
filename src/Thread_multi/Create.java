package Thread_multi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * �������̡߳�
 * M1.����Thread������start();
 * M2.ʵ��Runnable������MyThread;\
 * M3.ʵ��Callable(�����)
 */
public class Create {
    //�þ�̬��ɳ����ȥ���˴�ֻΪ��ʾ���㣬��main������ͬһ����
    public static class MyThread extends Thread{
        public MyThread(){}//һ��Ҫ��Ĭ�Ϲ��캯����������ʵ����
        public MyThread(String name){super(name);}
        @Override
        public void run(){
            for (int i=0;i<10;i++)
                System.out.println(getName()+":"+i);
        }
    }
    public static class MyRunnable implements Runnable{
        @Override
        public void run() {
            for(int i=0; i<10; i++) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //M1.ʹ��MyThread
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread("M1_1");
        MyThread t3 = new MyThread();
        t3.setName("M1_2");
//        t1.start();
//        t2.start();
//        t3.start();

        //����MyRunnable��Ķ���
        MyRunnable my = new MyRunnable();
        //����Thread��Ķ��󣬰�MyRunnable������Ϊ���췽���Ĳ���
        //����1.Thread(Runnable target)
         Thread t4 = new Thread(my);
         Thread t5 = new Thread(my, "MyThread(MyRunnable)");
//         t4.start();
//         t5.start();

         //M3.ʵ��Callable
//        method1();
        method2();
    }



    private static void method1() throws ExecutionException, InterruptedException {
        ExecutorService executorPool = Executors.newFixedThreadPool(10);
        //����һ��Callable��3��󷵻�String����
        Callable myCallable = new Callable() {
            @Override
            public String call() throws Exception {//��������ֵ����ΪString
                Thread.sleep(3000);
                System.out.println("call��������ִ��");
                return "call��������ֵ";
            }
        };
        System.out.println("�ύ����֮ǰ"+getStringDate());
        Future future = executorPool.submit(myCallable);
        System.out.println("�ύ����֮�󣬻�ȡ���֮ǰ "+getStringDate());
        System.out.println("��÷���ֵ: "+future.get());
        System.out.println("��ý��֮�� "+getStringDate());
    }

    private static void method2() throws ExecutionException, InterruptedException {
        ExecutorService executorPool = Executors.newFixedThreadPool(10);
        //����һ��Callable��3��󷵻�String����
        Callable myCallable = new Callable() {
            @Override
            public String call() throws Exception {//��������ֵ����ΪString
                Thread.sleep(3000);
                System.out.println("call��������ִ��");
                return "call��������ֵ";
            }
        };
        // ��������з���ֵ������
        List<Future> list = new ArrayList<Future>();
        for (int i = 0; i < 10; i++) {
            Future f = executorPool.submit(myCallable);
            list.add(f);
        }
        for (Future f:list){
            // �� Future �����ϻ�ȡ����ķ���ֵ�������������̨
            System.out.println(f.get().toString());
        }
    }


    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
}