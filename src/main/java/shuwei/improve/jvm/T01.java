package shuwei.improve.jvm;

public class T01 {
  class User {
    int id;
    String name;

    public User(int id, String name) {
      super();
      this.id = id;
      this.name = name;
    }
  }

  public void newObject(int i) {
    User u = new User(i, "name" + i);
  }

  public static void main(String[] args) {
    T01 t = new T01();
    long start = System.currentTimeMillis();
    for (int i = 0; i < 10000000; i++) {
      t.newObject(i);
    }
    long end = System.currentTimeMillis();
    System.out.println(end - start);
  }
}
