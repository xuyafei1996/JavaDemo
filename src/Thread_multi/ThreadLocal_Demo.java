package Thread_multi;
/**
 * 【ThreadLocal】
 * 把静态类MyDdata存入ThreadLocal，作为共享变量
 * 静态类A，B获取MyData中的数据
 * main方法通过单例模式实例化MyData，静态类A，B从MyData中取数据
 */

import java.util.Random;

public class ThreadLocal_Demo {
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt(889);
                    System.out.println(Thread.currentThread().getName()+"产生数据"+data);
                    MyData myData = MyData.getInstance();
                    myData.setName("Name:"+data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }


    static class A{	//可以直接使用获取到的线程范围内的对象实例调用相应方法
        String name = MyData.getInstance().getName();
        int age = MyData.getInstance().getAge();
        public void get(){
            System.out.println(Thread.currentThread().getName()+"-- AA name:"+name+"...age:"+age);
        }
    }

    static class B{
        //可以直接使用获取到的线程范围内的对象实例调用相应方法
        String name = MyData.getInstance().getName();
        int age = MyData.getInstance().getAge();
        public void get(){
            System.out.println(Thread.currentThread().getName()+"-- BB name:"+name+"...age:"+age);
        }
    }

    static class MyData{
        private String name;
        private int age;
        public String getName(){return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        //单例
        private MyData() {};
        //提供获取实例方法
        public static MyData getInstance() {
            //从当前线程范围内数据集中获取实例对象
            MyData instance = threadLocal.get();
            if (instance==null){
                instance = new MyData();
                threadLocal.set(instance);
            }
            return instance;
        }
        //将实例对象存入当前线程范围内数据集中
        static ThreadLocal<MyData> threadLocal = new ThreadLocal<MyData>();
    }

}
