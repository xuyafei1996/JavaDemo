package DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class test {
    public static void main(String[] args) {
        //创建实例对象/被代理对象
        Vehical car = new Car();
        //创建与代理对象相关联的InvocationHandler
        InvocationHandler carHandler = new VehicalInvocationHandler(car);
        //创建一个代理对象carProxy来代理car
        //代理对象的每个执行方法都会替换执行Invocation中的invoke方法
        Vehical carProxy = (Vehical) Proxy.newProxyInstance(car.getClass().getClassLoader(),
                car.getClass().getInterfaces(),carHandler);
        carProxy.run();
    }
}
