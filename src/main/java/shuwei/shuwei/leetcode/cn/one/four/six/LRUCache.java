package shuwei.shuwei.leetcode.cn.one.four.six;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
  private int capacity;
  private Map<Integer, Node> addMap;
  private Map<Integer, Integer> dataMap;
  private MyLinked myLinked = new MyLinked();

  public LRUCache(int capacity) {
    this.capacity = capacity;
    addMap = new HashMap<>(capacity);
    dataMap = new HashMap<>(capacity);
  }

  public int get(int key) {
    Integer val = dataMap.get(key);
    if (val == null) {
      return -1;
    } else {
      this.myLinked.headNode(addMap.get(key));
      return val;
    }
  }

  public void put(int key, int value) {
    Node address = addMap.get(key);
    if (address != null) {
      this.myLinked.headNode(address);
      this.dataMap.put(key, value);
    } else {
      // 本来不存在的key
      if (addMap.size() == this.capacity) {
        // 删除尾巴
        Integer tailKey = this.myLinked.deleteTail();
        this.addMap.remove(tailKey);
        this.dataMap.remove(tailKey);
      }
      addMap.put(key, this.myLinked.addHead(key));
      this.dataMap.put(key, value);
    }
  }
}

class MyLinked {
  private Node head;
  private Node tail;

  // 将某个node放到头部
  void headNode(Node node) {
    if (node == this.head) {
      return;
    }
    Node pre = node.pre;
    Node next = node.next;
    pre.next = next;
    if (next != null) {
      next.pre = pre;
    } else {
      // 被提前的是尾巴
      tail = pre;
    }
    node.pre = null;
    node.next = head;
    head.pre = node;
    head = node;
  }

  Node addHead(Integer key) {
    Node newHead = new Node(key);
    if (this.head != null) {
      newHead.next = this.head;
      this.head.pre = newHead;
    }
    this.head = newHead;
    if (this.tail == null) {
      this.tail = newHead;
    }
    return newHead;
  }

  Integer deleteTail() {
    Node tail = this.tail;
    Node lastSec = tail.pre;
    if (lastSec != null) {
      lastSec.next = null;
      this.tail = lastSec;
      tail.pre = null;
    } else {
      this.head = null;
      this.tail = null;
    }
    return tail.key;
  }
}

class Node {
  Node pre;
  Node next;
  Integer key;

  public Node(Integer key) {
    this.key = key;
  }
}