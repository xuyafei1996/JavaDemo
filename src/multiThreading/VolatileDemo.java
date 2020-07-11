package multiThreading;

import java.util.ArrayList;
import java.util.List;

public class VolatileDemo {
        //提供一个容器
        // volatile修饰的是list的地址，线程1修改list的内容后，刷回主存的时间是不确定的，线程2结束的时间可能不一致
        volatile List list = new ArrayList();
        //这是一个add方法
        public void add(Object o){
            list.add(o);
        }
        //这是一个size方法
        public int size(){
            return list.size();
        }
        public static void main(String[] args) {
            VolatileDemo volatileDemo = new VolatileDemo();
            //新建一个线程B,用于监控容器的个数
            new Thread(()->{
                while(true){
                    if(volatileDemo.size()==5){
                        break;
                    }
                }
                System.out.println("线程t2 结束");
            },"t2").start();
            //这是一个线程A,添加Object到容器中
            new Thread(()->{
                for (int i = 0; i < 10; i++) {
                    volatileDemo.add(new Object());
                    System.out.println("add "+i);
                    //线程2操作完list后，给它一段更新的时间
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //为保证值的可见性，让线程1操作一次list休息一会，好等到把最新值刷回主存去
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"t1").start();
        }
    }

