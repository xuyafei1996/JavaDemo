package multiThreading;

/**
 * 【演示5.线程控制——同步方法join()】
 * */
public class ThreadDemo5_join {
    //该静态类可抽离出去，此处只为表示方便，与main集合在同一类中
    public static class ThreadJoin extends Thread{
        @Override
        public void run(){
            for (int i=0;i<10;i++){
                System.out.println(getName()+":"+i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadJoin tj1 = new ThreadJoin();
        ThreadJoin tj2 = new ThreadJoin();
        ThreadJoin tj3 = new ThreadJoin();
        tj1.setName("康熙");
        tj2.setName("四阿哥");
        tj3.setName("八阿哥");
        tj1.start();
        //同步方法：使所有线程都暂停,等待tj1的执行完毕
        tj1.join();
        tj2.start();
        tj3.start();
    }
}
