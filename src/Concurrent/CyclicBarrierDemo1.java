package Concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo1 {
    public static void main(String[] args) {
        //到一个CyclicBarrier实例
        CyclicBarrier cb = new CyclicBarrier(4);
        new Thread(new Fishing(cb),"1").start();
        new Thread(new Fishing(cb),"2").start();
        new Thread(new Fishing(cb),"3").start();
        new Thread(new Fishing(cb),"4").start();
    }

    //静态类
    static class Fishing implements Runnable{
        CyclicBarrier cb;
        public Fishing(CyclicBarrier cb) {
            this.cb = cb;
        }

        @Override
        public void run() {
            try {
                System.out.println("第（" + Thread.currentThread().getName() + "）个人开始钓鱼");
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程执行完毕，继续处理其他任务，比如数据操作");
        }
    }
}