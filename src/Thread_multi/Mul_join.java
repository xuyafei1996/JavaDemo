package Thread_multi;

/**
 * 【同步方法】join()
 * 让主线程(main)等待子线程(T1)执行完后再执行；
 * 变并行为串行
 * */
public class Mul_join {
    //该静态类可抽离出去，此处只为表示方便，与main集合在同一类中
    public static class ThreadJoin extends Thread{
        public ThreadJoin(String name){super(name);}
        @Override
        public void run(){
            for (int i=0;i<10;i++){
                System.out.println(getName()+":"+i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadJoin tj1 = new ThreadJoin("康熙");
        ThreadJoin tj2 = new ThreadJoin("四阿哥");
        ThreadJoin tj3 = new ThreadJoin("八阿哥");
        tj1.start();
        //同步方法：使所有线程都暂停,等待tj1的执行完毕
        //main线程放弃cpu控制权，并返回t1线程继续执行直到线程t1执行完毕
        tj1.join();
        tj2.start();
        tj3.start();
    }
}
