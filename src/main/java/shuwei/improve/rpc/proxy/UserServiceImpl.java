package shuwei.improve.rpc.proxy;

public class UserServiceImpl implements UserService {
  @Override
  public User getUserById(Long id) {
    System.out.println("in UserServiceImpl getUserById " + id);
    User u = new User();
    u.setId(id);
    u.setName("sw");
    return u;
  }

  @Override
  public User getUSerByName(String name) {
    System.out.println("in UserServiceImpl getUserByName " + name);
    User u = new User();
    u.setId(1000L);
    u.setName(name);
    return u;
  }
}
