package multiThreading;

public class RunnableDaemon_SellTicket_synchronized {
    public static class SellTicket implements Runnable{
        private int tickets = 10;
        private Object obj = new Object();
        @Override
        public void run() {
            while (true) {
                synchronized (obj){
                    if (tickets > 0) {
                        System.out.println(Thread.currentThread().getName() + "���ڳ��۵�" + tickets + "��Ʊ");
                        tickets--;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        //����SellTicket��Ķ���
        SellTicket st = new SellTicket();
        //��������Thread����󣬰�SellTicket������Ϊ���췽���Ĳ�������������Ӧ�Ĵ�������
        Thread t1 = new Thread(st,"����1");
        Thread t2 = new Thread(st,"����2");
        Thread t3 = new Thread(st,"����3");
        t1.start();
        t2.start();
        t3.start();
    }
}