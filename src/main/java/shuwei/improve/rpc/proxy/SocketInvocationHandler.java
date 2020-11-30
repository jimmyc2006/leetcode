package shuwei.improve.rpc.proxy;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * jdk自带的动态代理
 */
public class SocketInvocationHandler implements InvocationHandler {

  private Class clazz;

  public SocketInvocationHandler(Class clazz) {
    this.clazz = clazz;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    Socket s = new Socket("127.0.0.1", 12345);
    OutputStream outputStream = s.getOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(outputStream);
    oos.writeUTF(clazz.getName());
    oos.writeUTF(method.getName());
    oos.writeObject(method.getParameterTypes());
    oos.writeObject(args);
    oos.flush();
    InputStream inputStream = s.getInputStream();
    ObjectInputStream ois = new ObjectInputStream(inputStream);
    return ois.readObject();
  }
}

