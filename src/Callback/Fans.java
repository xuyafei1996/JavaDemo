package Callback;

public class Fans implements CallBackInterface {
    //粉丝收到通知
    @Override
    public void execute() {
        for (int i=1;i<=10;i++){
            System.out.println(i+"号粉丝收到了通知，时间："+System.currentTimeMillis());
        }
    }
}
