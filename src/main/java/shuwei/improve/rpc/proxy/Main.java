package shuwei.improve.rpc.proxy;

import java.lang.reflect.Proxy;

public class Main {
  public static void main(String[] args) {
    UserService us = (UserService) Proxy.newProxyInstance(Main.class.getClassLoader(), new Class[]{UserService.class},
            new UserServiceInvocationHandler(new UserServiceImpl()));
//    User u = us.getUserById(123L);
    User u = us.getUSerByName("ss");
    System.out.println(u);
  }
}
