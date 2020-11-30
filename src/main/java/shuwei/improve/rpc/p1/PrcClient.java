package shuwei.improve.rpc.p1;

import java.lang.reflect.Proxy;

import shuwei.improve.rpc.proxy.SocketInvocationHandler;
import shuwei.improve.rpc.proxy.UserService;

public class PrcClient {

  public static void main(String[] args) {
    UserService us = getUserService(UserService.class);
    System.out.println(us.getUserById(1L));
    System.out.println(us.getUSerByName("haha"));
  }

  private static <T> T getUserService(Class<T> clazz) {
    return (T) Proxy.newProxyInstance(PrcClient.class.getClassLoader(), new Class[]{clazz},
            new SocketInvocationHandler(clazz));
  }
}
