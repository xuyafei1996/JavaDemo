package Callback;

public class UP {
    private CallBackInterface callBack = null;

    //���߷�˿���пվ͸���
    public void setCallBack(CallBackInterface callBack){
        this.callBack = callBack;
    }

    public void work(){
        System.out.println("���¸�������ˣ�");
        callBack.execute();
    }
}