package shuwei.improve.rpc.p1;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

import shuwei.improve.rpc.proxy.UserService;
import shuwei.improve.rpc.proxy.UserServiceImpl;

/**
 * 这里动态代理UserService
 */
public class RpcServer {
  public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
    ServerSocket ss;
    ss = new ServerSocket(12345);
    while (true) {
      Socket accept = ss.accept();
      InputStream inputStream = accept.getInputStream();
      ObjectInputStream ois = new ObjectInputStream(inputStream);
      String className = ois.readUTF();
      Class<?> clazz  = null;
      // 这里如果是spring，可以使用context获取实现
      if (className.equals(UserService.class.getName())) {
        clazz = UserServiceImpl.class;
      }
      String methodName = ois.readUTF();
      Class[] parameterType = (Class[]) ois.readObject();
      Object[] parameters = (Object[]) ois.readObject();
      Object o = clazz.newInstance();
      Method m = clazz.getDeclaredMethod(methodName, parameterType);
      Object invoke = m.invoke(o, parameters);
      OutputStream outputStream = accept.getOutputStream();
      ObjectOutputStream oos = new ObjectOutputStream(outputStream);
      oos.writeObject(invoke);
      accept.close();
    }
  }

}
