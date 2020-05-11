package shuwei.improve.sf1.link;

import java.util.Stack;

// 反转一个单向链表
public class ReverseLink {

  public static void main(String[] args) {
    ReverseLink link = new ReverseLink();
    Node testData = link.gen(new int[] {1, 3, 5, 7, 9, 11});
    Node rev = link.reverseLink(testData);
    link.traversal(rev);
    System.out.println();
    link.reverseTrabersal(rev);
    System.out.println();
    link.reverseTrabersal2(rev);
  }
  
  // 反转一个单向链表
  public Node reverseLink(Node root) {
    Node curr = root;
    Node prev = null;
    while (curr != null) {
      Node next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  private void traversal(Node root) {
    while (root != null) {
      System.out.print(root.val + " ");
      root = root.next;
    }
  }
  
  // 从尾到头打印单向链表
  private void reverseTrabersal(Node root) {
    if (root.next == null) {
      System.out.print(root.val + " > ");
    } else {
      reverseTrabersal(root.next);
      System.out.print(root.val + " > ");
    }
  }
  
  private void reverseTrabersal2(Node root) {
    Stack<Node> stack = new Stack<>();
    while(root != null) {
      stack.add(root);
      root = root.next;
    }
    while (!stack.isEmpty()) {
      System.out.print(stack.pop().val + " >> ");
    }
  }
  
  private Node gen(int[] arr) {
    Node root = new Node(arr[0]);
    Node curr = root;
    for (int i = 1; i < arr.length; i++) {
      curr.next = new Node(arr[i]);
      curr = curr.next;
    }
    return root;
  }
}

class Node {
  int val;
  Node next;

  public Node(int val) {
    super();
    this.val = val;
  }
}