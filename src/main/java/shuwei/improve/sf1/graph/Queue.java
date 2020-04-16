package shuwei.improve.sf1.graph;
/** 
* @author shuwei 
* @version 创建时间：2020年4月15日 下午5:05:05 
* 类说明 
*/
public class Queue {
  private final int SIZE = 20;
  private int[] queArray;
  private int front;
  private int rear;
  
  public Queue() {
    queArray = new int[SIZE];
    front = 0;
    rear = -1;
  }
  
  public void insert(int j) {
    if (rear == SIZE - 1) {
      rear = -1;
    }
    queArray[++rear] = j;
  }
  
  public int remove() {
    int temp = queArray[front++];
    if (front == SIZE) {
      front = 0;
    }
    return temp;
  }
  
  public boolean isEmpty() {
    return (rear + 1 == front || (front + SIZE - 1 == rear));
  }
}
