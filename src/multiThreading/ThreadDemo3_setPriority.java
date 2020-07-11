package multiThreading;

/**
 * ����ʾ3.�߳����ȼ���
 * */
public class ThreadDemo3_setPriority {
    //�þ�̬��ɳ����ȥ���˴�ֻΪ��ʾ���㣬��main������ͬһ����
    public static class ThreadPriority extends Thread{
        @Override
        public void run(){
            for (int i=0;i<10;i++){
                System.out.println(getName()+":"+i);
            }
        }
    }

    public static void main(String[] args) {
        ThreadPriority tp1 = new ThreadPriority();
        ThreadPriority tp2 = new ThreadPriority();
        ThreadPriority tp3 = new ThreadPriority();
        tp1.setName("����");
        tp2.setName("�ɻ�");
        tp3.setName("�ִ�");
        //�����߳����ȼ�
        System.out.println(tp1.getPriority()); //5
        System.out.println(tp2.getPriority()); //5
        System.out.println(tp3.getPriority()); //5
        System.out.println(Thread.MAX_PRIORITY); //10
        System.out.println(Thread.MIN_PRIORITY); //1
        System.out.println(Thread.NORM_PRIORITY); //5
        //�����߳����ȼ�
        //tp1.setPriority(10000); //IllegalArgumentException
        tp1.setPriority(5);
        tp2.setPriority(10);
        tp3.setPriority(1);
        tp1.start();
        tp2.start();
        tp3.start();
    }
}