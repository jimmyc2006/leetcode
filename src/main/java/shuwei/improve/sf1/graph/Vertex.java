package shuwei.improve.sf1.graph;
/** 
* @author shuwei 
* @version 创建时间：2020年4月15日 下午5:10:15 
* 类说明 
*/
public class Vertex {
  public char label;
  public boolean wasVisited;
  
  public Vertex(char lab) {
    label = lab;
    wasVisited = false;
  }
}
