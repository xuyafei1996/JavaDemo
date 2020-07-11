package DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class test {
    public static void main(String[] args) {
        //����ʵ������/����������
        Vehical car = new Car();
        //��������������������InvocationHandler
        InvocationHandler carHandler = new VehicalInvocationHandler(car);
        //����һ����������carProxy������car
        //���������ÿ��ִ�з��������滻ִ��Invocation�е�invoke����
        Vehical carProxy = (Vehical) Proxy.newProxyInstance(car.getClass().getClassLoader(),
                car.getClass().getInterfaces(),carHandler);
        carProxy.run();
    }
}