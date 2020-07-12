package multiThreading;

public class RunnableDemo_SellTicket_synchronized {
    public static class SellTicket implements Runnable{
        private int tickets = 10;
        private Object obj = new Object();
        @Override
        public void run() {
            while (true) {
                //锁住该对象实例
                synchronized (obj){
                    if (tickets > 0) {
                        System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票");
                        tickets--;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        //创建SellTicket类的对象
        SellTicket st = new SellTicket();
        //创建三个Thread类对象，把SellTicket对象作为构造方法的参数，并给出对应的窗口名称
        Thread t1 = new Thread(st,"窗口1");
        Thread t2 = new Thread(st,"窗口2");
        Thread t3 = new Thread(st,"窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
