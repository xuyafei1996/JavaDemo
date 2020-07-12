package Thread_multi;


import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ����д����
 * ���������̶߳��������߳�д
 * ��������Source�У��Զ�д�������϶�д��
 */
public class Lock_ReadWriteLock {
    public static void main(String[] args) {
        //��������
        final Source source = new Source() ;
        //������д�߳�
        for (int i = 0; i < 3; i++) {
            //���߳�
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true)
                        source.get();
                }
            }).start();
            //д�߳�
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        source.put(new Random().nextInt(999));
                    }
                }
            }).start();
        }
    }

    static class Source{
        //��������
        private int data = 0;
        //Ҫ����ͬһ�����ϵĶ���д��
        ReadWriteLock rwl = new ReentrantReadWriteLock();

        //������
        public void get(){
            //�϶���
            rwl.readLock().lock();
            try{
                //��ȡ���ݲ����
                System.out.println("������"+Thread.currentThread().getName()+"���ڶ�ȡ���ݡ���");
                try{
                    Thread.sleep(new Random().nextInt(6)*1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("������"+Thread.currentThread().getName()+"�������ݣ�"+data);
            }finally{
                //����
                rwl.readLock().unlock();
            }
        }
        //д����
        public void put(int data){
            //��д��
            rwl.writeLock().lock();
            try{
                //��ʾ��Ϣ
                System.out.println("д����"+Thread.currentThread().getName()+"���ڸ�д���ݡ���");
                try{
                    Thread.sleep(new Random().nextInt(6)*1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                this.data = data;
                System.out.println("д����"+Thread.currentThread().getName()+"�ѽ����ݸ�дΪ��"+data);
            }finally{
                //����
                rwl.writeLock().unlock();
            }
        }
    }
}
