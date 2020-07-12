package multiThreading;

public class RunnableDemo_start {
    public static class MyRunnable implements Runnable{
        @Override
        public void run() {
            for(int i=0; i<10; i++) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }

    public static void main(String[] args) {
        //创建MyRunnable类的对象
        MyRunnable my = new MyRunnable();
        //创建Thread类的对象，把MyRunnable对象作为构造方法的参数
        //方法1.Thread(Runnable target)
         Thread t1 = new Thread(my);
         Thread t2 = new Thread(my);
         t1.start();
         t2.start();

        //方法2.Thread(Runnable target, String name)
//         Thread t1 = new Thread(my,"高铁");
//         Thread t2 = new Thread(my,"飞机");
//         t1.start();
//         t2.start();
    }
}
