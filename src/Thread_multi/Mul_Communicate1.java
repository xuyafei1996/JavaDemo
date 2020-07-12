package Thread_multi;

/**
 * ���߳�ͨ�š�
 * �����ߺ������ߣ�������������
 * ������������ϣ����������ߣ������ߵ�put����ʹ��synchronized����
 * ������������ϣ����������ߣ������ߵ�get����ʹ��synchronized����
 */
public class Mul_Communicate1 {
    public static class Box{
        //����һ����Ա��������ʾ��xƿ��
        private int milk;
        //����һ����Ա��������ʾ��������ţ��
        private boolean state = false;
        //�ṩ�洢ţ�̺ͻ�ȡţ�̵Ĳ���
        public synchronized void put(int milk) throws InterruptedException {
            //�����ţ�̣��ȴ�����
            if(state)
                    wait();
            //���û��ţ�̣�������ţ��
            this.milk = milk;
            System.out.println("���̹�����" + this.milk + "ƿ�̷�������");
            //�������֮���޸�����״̬
            state = true;
            //���������ȴ����߳�
            notifyAll();
        }
        public synchronized void get() throws InterruptedException {
            //���û��ţ�̣��ȴ�����
            if(!state)
                    wait();
            //�����ţ�̣�������ţ��
            System.out.println("�û��õ���" + this.milk + "ƿ��");
            //�������֮���޸�����״̬
            state = false;
            //���������ȴ����߳�
            notifyAll();
        }
    }

    public static class Producer implements Runnable{
        private Box box;
        public Producer(Box box){this.box = box;}
        @Override
        public void run() {
            for (int i=0;i<=30;i++) {
                try {
                    box.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static class Consumer implements Runnable{
        private Box box;
        public Consumer(Box box){this.box = box;}
        @Override
        public void run() {
            while (true) {
                try {
                    box.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        //��������������ǹ�����������
        Box box = new Box();
        //���������߶��󣬴����������(������������)�����д洢ţ�̲���
        Producer p = new Producer(box);
        //���������߶��󣬴����������(������������)�����л�ȡţ�̲���
        Consumer c = new Consumer(box);
        //����2���̶߳��󣬷ֱ�������߶���������߶�����Ϊ���췽����������
        Thread t1 = new Thread(p,"������");
        Thread t2 = new Thread(c,"������");
        t1.start();
        t2.start();
    }
}