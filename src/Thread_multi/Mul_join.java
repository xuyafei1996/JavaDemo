package Thread_multi;

/**
 * ��ͬ��������join()
 * �����߳�(main)�ȴ����߳�(T1)ִ�������ִ�У�
 * �䲢��Ϊ����
 * */
public class Mul_join {
    //�þ�̬��ɳ����ȥ���˴�ֻΪ��ʾ���㣬��main������ͬһ����
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
        ThreadJoin tj1 = new ThreadJoin("����");
        ThreadJoin tj2 = new ThreadJoin("�İ���");
        ThreadJoin tj3 = new ThreadJoin("�˰���");
        tj1.start();
        //ͬ��������ʹ�����̶߳���ͣ,�ȴ�tj1��ִ�����
        //main�̷߳���cpu����Ȩ��������t1�̼߳���ִ��ֱ���߳�t1ִ�����
        tj1.join();
        tj2.start();
        tj3.start();
    }
}