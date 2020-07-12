package Thread_multi;

/**
 * 【线程通信】
 * 生产者和消费者，操作共享数据
 * 生产者生产完毕，唤醒消费者：生产者的put方法使用synchronized加锁
 * 消费者生产完毕，唤醒生产者：消费者的get方法使用synchronized加锁
 */
public class Mul_Communicate1 {
    public static class Box{
        //定义一个成员变量，表示第x瓶奶
        private int milk;
        //定义一个成员变量，表示奶箱有无牛奶
        private boolean state = false;
        //提供存储牛奶和获取牛奶的操作
        public synchronized void put(int milk) throws InterruptedException {
            //如果有牛奶，等待消费
            if(state)
                    wait();
            //如果没有牛奶，就生产牛奶
            this.milk = milk;
            System.out.println("送奶工将第" + this.milk + "瓶奶放入奶箱");
            //生产完毕之后，修改奶箱状态
            state = true;
            //唤醒其他等待的线程
            notifyAll();
        }
        public synchronized void get() throws InterruptedException {
            //如果没有牛奶，等待生产
            if(!state)
                    wait();
            //如果有牛奶，就消费牛奶
            System.out.println("用户拿到第" + this.milk + "瓶奶");
            //消费完毕之后，修改奶箱状态
            state = false;
            //唤醒其他等待的线程
            notifyAll();
        }
    }

    public static class Producer implements Runnable{
        private Box box;
        public Producer(Box box){this.box = box;}
        @Override
        public void run() {
            for (int i=0;i<=30;i++) {
                try {
                    box.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static class Consumer implements Runnable{
        private Box box;
        public Consumer(Box box){this.box = box;}
        @Override
        public void run() {
            while (true) {
                try {
                    box.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        //创建奶箱对象，这是共享数据区域
        Box box = new Box();
        //创建生产者对象，传入奶箱对象(共享数据区域)，进行存储牛奶操作
        Producer p = new Producer(box);
        //创建消费者对象，传入奶箱对象(共享数据区域)，进行获取牛奶操作
        Consumer c = new Consumer(box);
        //创建2个线程对象，分别把生产者对象和消费者对象作为构造方法参数传递
        Thread t1 = new Thread(p,"生产者");
        Thread t2 = new Thread(c,"消费者");
        t1.start();
        t2.start();
    }
}
