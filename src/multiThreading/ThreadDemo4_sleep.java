package multiThreading;

/**
 * 【演示4.线程控制——睡眠方法sleep()】
 * */
public class ThreadDemo4_sleep {
    //该静态类可抽离出去，此处只为表示方便，与main集合在同一类中
    public static class ThreadSleep extends Thread{
        @Override
        public void run(){
            for (int i=0;i<10;i++){
                System.out.println(getName()+":"+i);
                //线程休眠
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadSleep ts1 = new ThreadSleep();
        ThreadSleep ts2 = new ThreadSleep();
        ThreadSleep ts3 = new ThreadSleep();
        ts1.setName("曹操");
        ts2.setName("刘备");
        ts3.setName("孙权");
        ts1.start();
        ts2.start();
        ts3.start();
    }
}
