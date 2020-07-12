package Thread_multi;

/**
 * ���ػ��̡߳�
 * setDaemon(true)
 * */
public class SetDaemon {
    //�þ�̬��ɳ����ȥ���˴�ֻΪ��ʾ���㣬��main������ͬһ����
    public static class ThreadDaemon extends Thread{
        @Override
        public void run(){
            for (int i=0;i<100;i++){
                System.out.println(getName()+":"+i);
            }
            try {
                Thread.sleep(2000L);
            }catch (Exception e){
                e.printStackTrace();
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
        //��t1,t2����Ϊ�ػ��߳�
        //�����ػ��̣߳���������û�пɷ�����߳�ʱ���Զ��뿪
        td1.setDaemon(true);
        td2.setDaemon(true);
        td1.start();
        td2.start();
        //���߳̽������ػ��߳̾ͽ���(������ִ�е�100�������ŷ�ִ�в���100)
        for(int i=0; i<=100; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}