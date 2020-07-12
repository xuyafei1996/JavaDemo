package Thread_multi;
/**
 * 【线程通信】
 * 使用Volatile修饰共享数据域
 * 线程T2监控线程T1，操作5次后自动结束
 */

import java.util.ArrayList;
import java.util.List;

public class Mul_Communicate2 {
        //提供一个容器
        // volatile修饰的是list的地址，线程1修改list的内容后，刷回主存的时间是不确定的，线程2结束的时间可能不一致
        volatile List list = new ArrayList();
        public void add(Object o){
            list.add(o);
        }
        public int size(){
            return list.size();
        }
        public static void main(String[] args) {
            Mul_Communicate2 volatileDemo = new Mul_Communicate2();
            //新建一个线程t2,用于监控容器的个数
            new Thread(()->{
                while(true){
                    if(volatileDemo.size()==5){
                        break;
                    }
                }
                System.out.println("线程t2 结束");
            },"t2").start();
            //这是一个线程t1,添加Object到容器中
            new Thread(()->{
                for (int i = 0; i < 10; i++) {
                    volatileDemo.add(new Object());
                    System.out.println("T1 add "+i);
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

