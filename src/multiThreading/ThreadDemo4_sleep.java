package multiThreading;

/**
 * ����ʾ4.�߳̿��ơ���˯�߷���sleep()��
 * */
public class ThreadDemo4_sleep {
    //�þ�̬��ɳ����ȥ���˴�ֻΪ��ʾ���㣬��main������ͬһ����
    public static class ThreadSleep extends Thread{
        @Override
        public void run(){
            for (int i=0;i<10;i++){
                System.out.println(getName()+":"+i);
                //�߳�����
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadSleep ts1 = new ThreadSleep();
        ThreadSleep ts2 = new ThreadSleep();
        ThreadSleep ts3 = new ThreadSleep();
        ts1.setName("�ܲ�");
        ts2.setName("����");
        ts3.setName("��Ȩ");
        ts1.start();
        ts2.start();
        ts3.start();
    }
}