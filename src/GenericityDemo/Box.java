package GenericityDemo;
//Box类会操作一种泛型T的对象
public class Box<T> {
    private T t;
    public void set(T t) { this.t = t; }
    public T get() { return t; }
}
