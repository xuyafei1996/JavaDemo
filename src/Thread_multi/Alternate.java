package Thread_multi;

/**
 * 【线程交替运行】
 * 循环执行50次；每轮子线程10次，然后主线程100次；
 */
public class Alternate {
    public static void main(String[] args) {
        int terms = 50;
        while (terms-->0){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    circle("子线程运行",10);
                }
            }).start();
            try{
                //加这句是保证上边的子线程先运行，刚开始没加，主线程就先开了
                Thread.sleep(2000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            circle("主线程", 100);
        }
    }

    /**
     * 线程交替运行
     * @param name 线程名
     * @param count 线程运行次数
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
