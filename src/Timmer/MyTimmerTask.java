package Timmer;
/**
 * ʵ��TimerTask
 */

import java.util.TimerTask;

public class MyTimmerTask extends TimerTask {
    private String taskName;
    public MyTimmerTask(String taskName){
        this.taskName = taskName;
    }
    public String getTaskName(){
        return taskName;
    }
    public void setTaskName(String taskName){
        this.taskName = taskName;
    }
    @Override
    public void run() {
        System.out.println("��ǰ���е������ǣ�"+taskName);
    }
}