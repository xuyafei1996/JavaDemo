package Callback;

public class Fans implements CallBackInterface {
    //��˿�յ�֪ͨ
    @Override
    public void execute() {
        for (int i=1;i<=10;i++){
            System.out.println(i+"�ŷ�˿�յ���֪ͨ��ʱ�䣺"+System.currentTimeMillis());
        }
    }
}