package multiThreading;

/**
 * ����ʾ2.��ȡ�߳�����
 * */
public class ThreadDemo2_getName {
    //�þ�̬��ɳ����ȥ���˴�ֻΪ��ʾ���㣬��main������ͬһ����
    public static class MyThread extends Thread{
        public MyThread(){}//һ��Ҫ��Ĭ�Ϲ��캯����������ʵ����
        public MyThread(String name){super(name);}
        @Override
        public void run(){
            for (int i=0;i<10;i++)
                System.out.println(getName()+":"+i);
        }
    }
    public static void main(String[] args) {
        //����1
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        //�����߳�����
        t1.setName("����");
        t2.setName("�ɻ�");
        t1.start();
        t2.start();
        System.out.println(Thread.currentThread().getName());

//        //����2
//        MyThread t1 = new MyThread("����");
//        MyThread t2 = new MyThread("�ɻ�");
//        //ʹ�ú��ι��췽���������߳�
//        t1.start();
//        t2.start();
//        System.out.println(Thread.currentThread().getName());
    }
}