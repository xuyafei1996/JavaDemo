package Timmer;

import java.util.Timer;

public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        MyTimmerTask myTask = new MyTimmerTask("MyTimerTask");
        //6���ִ��
//        timer.schedule(myTask,6000L);
        //3���ִ�У��ź�ÿ��1��ִ��һ��
        timer.schedule(myTask,3000L,1000L);
    }
}