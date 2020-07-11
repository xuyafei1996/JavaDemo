package multiThreading;

/**
 * ����ʾ5.�߳̿��ơ���ͬ������join()��
 * */
public class ThreadDemo5_join {
    //�þ�̬��ɳ����ȥ���˴�ֻΪ��ʾ���㣬��main������ͬһ����
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
        tj1.setName("����");
        tj2.setName("�İ���");
        tj3.setName("�˰���");
        tj1.start();
        //ͬ��������ʹ�����̶߳���ͣ,�ȴ�tj1��ִ�����
        tj1.join();
        tj2.start();
        tj3.start();
    }
}