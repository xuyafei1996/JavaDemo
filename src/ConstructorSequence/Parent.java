package ConstructorSequence;

public class Parent {
    public Parent(){
        System.out.println("父类无参构造方法");
    }
    public Parent(String name){
        System.out.println("父类有参构造方法"+name);
    }
    {
        System.out.println("父类构造代码块");
    }
    static {
        System.out.println("父类静态代码块");
    }
}
