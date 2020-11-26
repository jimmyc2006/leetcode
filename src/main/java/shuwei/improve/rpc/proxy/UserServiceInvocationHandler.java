package shuwei.improve.rpc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * jdk自带的动态代理
 */
public class UserServiceInvocationHandler implements InvocationHandler {

  private UserService us;

  public UserServiceInvocationHandler(UserService us) {
    this.us = us;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("------------invoke before method------------");
    Object invoke = method.invoke(us, args);
    System.out.println("------------invoke after method------------");
    System.out.println(proxy == us);
    return invoke;
  }
}

