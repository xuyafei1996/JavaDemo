package ConstructorSequence;

public class Son extends Parent {
    public Son(){
        System.out.println("�����޲ι�������");
    }
    public Son(String name){
        System.out.println("�����вι�������"+name);
    }
    {
        System.out.println("���๹������");
    }
    static {
        System.out.println("���ྲ̬�����");
    }

    public static void main(String[] args) {
        System.out.println("-------main start-------");
        Parent son1 = new Son();
        System.out.println("---------------------");
        Parent son2 = new Son("harry");
        System.out.println("-------main end-------");
    }
}