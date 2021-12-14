package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvokationHandler implements InvocationHandler{
	
	private Object obj;
	
	public MyInvokationHandler(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		Object result;
		if(method.getName().contains("work")){
            System.out.println("...work Method Executing...");
        }else if (method.getName().contains("value")) {
        	System.out.println("...getValue Method Executing...");
		}
		for (Object object : args) {
        	System.out.println(object.toString());
		}
        result = method.invoke(obj, args);
        return result;
	}

}
