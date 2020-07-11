package multiThreading;

/**
 * 【演示2.获取线程名】
 * */
public class ThreadDemo2_getName {
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
    public static void main(String[] args) {
        //方法1
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        //设置线程名称
        t1.setName("高铁");
        t2.setName("飞机");
        t1.start();
        t2.start();
        System.out.println(Thread.currentThread().getName());

//        //方法2
//        MyThread t1 = new MyThread("高铁");
//        MyThread t2 = new MyThread("飞机");
//        //使用含参构造方法，构造线程
//        t1.start();
//        t2.start();
//        System.out.println(Thread.currentThread().getName());
    }
}
