package shuwei.improve.rpc;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import shuwei.improve.rpc.proxy.UserServiceImpl;

public class RpcServer {

  /**
   * 使用socket实现rpc通信
   * @param args
   */
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    UserServiceImpl uService = new UserServiceImpl();
    ServerSocket ss = new ServerSocket(8888);
    while (true) {
      Socket accept = ss.accept();
      InputStream inputStream = accept.getInputStream();
      ObjectInputStream ois = new ObjectInputStream(inputStream);
      String className = ois.readUTF();
      String methodName = ois.readUTF();
      Class[] parameterTypes = (Class[]) ois.readObject();
      Object[] parameters = (Object[]) ois.readObject();
    }

  }

  private static Object call(String className, String methodName, Class[] paraTypes, Object[] paramters) throws ClassNotFoundException {
    Class<?> aClass = RpcServer.class.getClassLoader().loadClass(className);
    return null;
  }
}
