package ConstructorSequence;

public class Son extends Parent {
    public Son(){
        System.out.println("子类无参构造代码块");
    }
    public Son(String name){
        System.out.println("子类有参构造代码块"+name);
    }
    {
        System.out.println("子类构造代码块");
    }
    static {
        System.out.println("子类静态代码块");
    }

    public static void main(String[] args) {
        System.out.println("-------main start-------");
        Parent son1 = new Son();
        System.out.println("---------------------");
        Parent son2 = new Son("harry");
        System.out.println("-------main end-------");
    }
}
