package shuwei.leetcode.cn.three.four.one;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
  private Deque<List<NestedInteger>> listDeque = new LinkedList<>();
  private Deque<Integer> indexDeque = new LinkedList<>();

  public NestedIterator(List<NestedInteger> nestedList) {
    if (nestedList != null) {
      listDeque.addLast(nestedList);
      indexDeque.addLast(0);
    }
  }

  @Override
  public Integer next() {
    List<NestedInteger> nestedIntegers = listDeque.peekLast();
    Integer index = indexDeque.pollLast();
    Integer result = nestedIntegers.get(index).getInteger();
    indexDeque.addLast(index + 1);
    return result;
  }

  @Override
  public boolean hasNext() {
    if (listDeque.size() > 0) {
      List<NestedInteger> nestedIntegers = listDeque.peekLast();
      Integer index = indexDeque.peekLast();
      if (nestedIntegers.size() > index) {
        NestedInteger nestedInteger = nestedIntegers.get(index);
        if (nestedInteger.isInteger()) {
          return true;
        } else {
          listDeque.addLast(nestedInteger.getList());
          indexDeque.addLast(0);
          return hasNext();
        }
      } else {
        listDeque.pollLast();
        indexDeque.pollLast();
        if (indexDeque.size() > 0) {
          indexDeque.addLast(indexDeque.pollLast() + 1);
        }
        return hasNext();
      }
    }
    return false;
  }
}
