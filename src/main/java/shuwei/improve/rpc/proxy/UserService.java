package shuwei.improve.rpc.proxy;

public interface UserService {
  public User getUserById(Long id);
  public User getUSerByName(String name);
}
