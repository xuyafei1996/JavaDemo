package GenericityDemo;
//Box������һ�ַ���T�Ķ���
public class Box<T> {
    private T t;
    public void set(T t) { this.t = t; }
    public T get() { return t; }
}