package ConstructorSequence;

public class Parent {
    public Parent(){
        System.out.println("�����޲ι��췽��");
    }
    public Parent(String name){
        System.out.println("�����вι��췽��"+name);
    }
    {
        System.out.println("���๹������");
    }
    static {
        System.out.println("���ྲ̬�����");
    }
}