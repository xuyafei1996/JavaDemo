package Thread_multi;

/**
 * 【守护线程】
 * setDaemon(true)
 * */
public class SetDaemon {
    //该静态类可抽离出去，此处只为表示方便，与main集合在同一类中
    public static class ThreadDaemon extends Thread{
        @Override
        public void run(){
            for (int i=0;i<100;i++){
                System.out.println(getName()+":"+i);
            }
            try {
                Thread.sleep(2000L);
            }catch (Exception e){
                e.printStackTrace();
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
        //把t1,t2设置为守护线程
        //设置守护线程，当程序中没有可服务的线程时会自动离开
        td1.setDaemon(true);
        td2.setDaemon(true);
        td1.start();
        td2.start();
        //主线程结束，守护线程就结束(刘备能执行到100，关羽张飞执行不到100)
        for(int i=0; i<=100; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
