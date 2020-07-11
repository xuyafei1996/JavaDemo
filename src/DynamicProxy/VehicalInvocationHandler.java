package DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class VehicalInvocationHandler implements InvocationHandler {
    private Vehical vehical;
    public VehicalInvocationHandler(Vehical vehical){
        this.vehical = vehical;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("ǰ�÷�������");
        Object invoke = method.invoke(vehical,args);
        System.out.println("���÷�������");
        return invoke;
    }
}