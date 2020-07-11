package multiThreading;

/**
 * ����ʾ6.�߳̿��ơ����ػ��߳�setDaemon(true)��
 * */
public class ThreadDemo6_setDaemon {
    //�þ�̬��ɳ����ȥ���˴�ֻΪ��ʾ���㣬��main������ͬһ����
    public static class ThreadDaemon extends Thread{
        @Override
        public void run(){
            for (int i=0;i<100;i++){
                System.out.println(getName()+":"+i);
            }
        }
    }

    public static void main(String[] args) {
        ThreadDaemon td1 = new ThreadDaemon();
        ThreadDaemon td2 = new ThreadDaemon();
        td1.setName("����");
        td2.setName("�ŷ�");
        //�������߳�Ϊ����
        Thread.currentThread().setName("����");
        //�����ػ��̣߳���������û�пɷ�����߳�ʱ���Զ��뿪
        td1.setDaemon(true);
        td2.setDaemon(true);
        td1.start();
        td2.start();
        //���߳̽������ػ��߳̾ͽ���
        for(int i=0; i<10; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}