package Thread_multi;

/**
 * ���߳̽������С�
 * ѭ��ִ��50�Σ�ÿ�����߳�10�Σ�Ȼ�����߳�100�Σ�
 */
public class Alternate {
    public static void main(String[] args) {
        int terms = 50;
        while (terms-->0){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    circle("���߳�����",10);
                }
            }).start();
            try{
                //������Ǳ�֤�ϱߵ����߳������У��տ�ʼû�ӣ����߳̾��ȿ���
                Thread.sleep(2000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            circle("���߳�", 100);
        }
    }

    /**
     * �߳̽�������
     * @param name �߳���
     * @param count �߳����д���
     */
    private static void circle(String name, int count) {
        for (int i=1; i<=count; i++)
            System.out.println(name+"::"+i);
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}