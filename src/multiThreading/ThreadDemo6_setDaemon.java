package multiThreading;

/**
 * 【演示6.线程控制——守护线程setDaemon(true)】
 * */
public class ThreadDemo6_setDaemon {
    //该静态类可抽离出去，此处只为表示方便，与main集合在同一类中
    public static class ThreadDaemon extends Thread{
        @Override
        public void run(){
            for (int i=0;i<100;i++){
                System.out.println(getName()+":"+i);
            }
        }
    }

    public static void main(String[] args) {
        ThreadDaemon td1 = new ThreadDaemon();
        ThreadDaemon td2 = new ThreadDaemon();
        td1.setName("关羽");
        td2.setName("张飞");
        //设置主线程为刘备
        Thread.currentThread().setName("刘备");
        //设置守护线程，当程序中没有可服务的线程时会自动离开
        td1.setDaemon(true);
        td2.setDaemon(true);
        td1.start();
        td2.start();
        //主线程结束，守护线程就结束
        for(int i=0; i<10; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
