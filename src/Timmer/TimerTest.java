package Timmer;

import java.util.Timer;

public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        MyTimmerTask myTask = new MyTimmerTask("MyTimerTask");
        //6秒后执行
//        timer.schedule(myTask,6000L);
        //3秒后执行，伺候每个1秒执行一次
        timer.schedule(myTask,3000L,1000L);
    }
}
