package Callback;

public class test {
    public static void main(String[] args) {
        UP up = new UP();
        up.setCallBack(new Fans());
        up.work();
    }
}
