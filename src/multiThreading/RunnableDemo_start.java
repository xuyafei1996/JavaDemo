package multiThreading;

public class RunnableDemo_start {
    public static class MyRunnable implements Runnable{
        @Override
        public void run() {
            for(int i=0; i<10; i++) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }

    public static void main(String[] args) {
        //����MyRunnable��Ķ���
        MyRunnable my = new MyRunnable();
        //����Thread��Ķ��󣬰�MyRunnable������Ϊ���췽���Ĳ���
        //����1.Thread(Runnable target)
         Thread t1 = new Thread(my);
         Thread t2 = new Thread(my);
         t1.start();
         t2.start();

        //����2.Thread(Runnable target, String name)
//         Thread t1 = new Thread(my,"����");
//         Thread t2 = new Thread(my,"�ɻ�");
//         t1.start();
//         t2.start();
    }
}