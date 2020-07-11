package multiThreading;

/**
 * 【演示1.线程运行】
 * */
public class ThreadDemo1_runANDstart {
    //该静态类可抽离出去，此处只为表示方便，与main集合在同一类中
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
        //start()导致线程开始执行; JVM调用此线程的run方法
        t1.start();
        t2.start();
    }
}
