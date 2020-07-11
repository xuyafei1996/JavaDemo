package multiThreading;

/**
 * 【演示3.线程优先级】
 * */
public class ThreadDemo3_setPriority {
    //该静态类可抽离出去，此处只为表示方便，与main集合在同一类中
    public static class ThreadPriority extends Thread{
        @Override
        public void run(){
            for (int i=0;i<10;i++){
                System.out.println(getName()+":"+i);
            }
        }
    }

    public static void main(String[] args) {
        ThreadPriority tp1 = new ThreadPriority();
        ThreadPriority tp2 = new ThreadPriority();
        ThreadPriority tp3 = new ThreadPriority();
        tp1.setName("高铁");
        tp2.setName("飞机");
        tp3.setName("轮船");
        //返回线程优先级
        System.out.println(tp1.getPriority()); //5
        System.out.println(tp2.getPriority()); //5
        System.out.println(tp3.getPriority()); //5
        System.out.println(Thread.MAX_PRIORITY); //10
        System.out.println(Thread.MIN_PRIORITY); //1
        System.out.println(Thread.NORM_PRIORITY); //5
        //更改线程优先级
        //tp1.setPriority(10000); //IllegalArgumentException
        tp1.setPriority(5);
        tp2.setPriority(10);
        tp3.setPriority(1);
        tp1.start();
        tp2.start();
        tp3.start();
    }
}
