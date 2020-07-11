package Callback;

public class UP {
    private CallBackInterface callBack = null;

    //告诉粉丝，有空就更新
    public void setCallBack(CallBackInterface callBack){
        this.callBack = callBack;
    }

    public void work(){
        System.out.println("文章更新完成了！");
        callBack.execute();
    }
}
