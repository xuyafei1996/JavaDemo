package multiThreading;

/**
 * ����ʾ1.�߳����С�
 * */
public class ThreadDemo1_runANDstart {
    //�þ�̬��ɳ����ȥ���˴�ֻΪ��ʾ���㣬��main������ͬһ����
    public static class MyThread extends Thread{
        @Override
        public void run(){
            for (int i=0;i<10;i++)
                System.out.println(i);
        }
    }
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        //t1.run();
        //t2.run();
        //start()�����߳̿�ʼִ��; JVM���ô��̵߳�run����
        t1.start();
        t2.start();
    }
}