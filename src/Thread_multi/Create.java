package Thread_multi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * 【创建线程】
 * M1.基础Thread，调用start();
 * M2.实现Runnable，传入MyThread;\
 * M3.实现Callable(待完成)
 */
public class Create {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //M1.使用MyThread
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread("M1_1");
        MyThread t3 = new MyThread();
        t3.setName("M1_2");
//        t1.start();
//        t2.start();
//        t3.start();

        //创建MyRunnable类的对象
        MyRunnable my = new MyRunnable();
        //创建Thread类的对象，把MyRunnable对象作为构造方法的参数
        //方法1.Thread(Runnable target)
        Thread t4 = new Thread(my);
        Thread t5 = new Thread(my, "MyThread(MyRunnable)");
//         t4.start();
//         t5.start();

        //M3.实现Callable
//        method1();
        method2();
    }

    //该静态类可抽离出去，此处只为表示方便，与main集合在同一类中
    public static class MyThread extends Thread{
        public MyThread(){}//一定要有默认构造函数，否则不能实例化
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
    private static void method1() throws ExecutionException, InterruptedException {
        ExecutorService executorPool = Executors.newFixedThreadPool(10);
        //创建一个Callable，3秒后返回String类型
        Callable myCallable = new Callable() {
            @Override
            public String call() throws Exception {//声明返回值类型为String
                Thread.sleep(3000);
                System.out.println("call方法正在执行");
                return "call方法返回值";
            }
        };
        System.out.println("提交任务之前"+getStringDate());
        Future future = executorPool.submit(myCallable);
        System.out.println("提交任务之后，获取结果之前 "+getStringDate());
        System.out.println("获得返回值: "+future.get());
        System.out.println("获得结果之后 "+getStringDate());
    }
    private static void method2() throws ExecutionException, InterruptedException {
        ExecutorService executorPool = Executors.newFixedThreadPool(10);
        //创建一个Callable，3秒后返回String类型
        Callable myCallable = new Callable() {
            @Override
            public String call() throws Exception {//声明返回值类型为String
                Thread.sleep(3000);
                System.out.println("call方法正在执行");
                return "call方法返回值";
            }
        };
        // 创建多个有返回值的任务
        List<Future> list = new ArrayList<Future>();
        for (int i = 0; i < 10; i++) {
            Future f = executorPool.submit(myCallable);
            list.add(f);
        }
        for (Future f:list){
            // 从 Future 对象上获取任务的返回值，并输出到控制台
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
