package shuwei.leetcode.cn.three.eight.one;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class RandomizedCollection {
  private LinkedHashMap<Integer, Integer> data;
  /** Initialize your data structure here. */
  public RandomizedCollection() {
    data = new LinkedHashMap<>();
  }

  /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
  public boolean insert(int val) {
    Integer count = data.get(val);
    if (count == null) {
      data.put(val, 1);
      initIterator();
      return true;
    } else {
      data.put(val, count + 1);
      return false;
    }
  }

  /** Removes a value from the collection. Returns true if the collection contained the specified element. */
  public boolean remove(int val) {
    Integer count = data.get(val);
    if (count == null) {
      return false;
    } else {
      if (count - 1 == 0) {
        data.remove(val);
        initIterator();
      } else {
        data.put(val, count - 1);
      }
      return true;
    }
  }

  private void initIterator() {
    if (data.size() == 0){
      iterator = null;
    }
    iterator = data.entrySet().iterator();
    index = 0;
    currEntry = null;
  }

  private Iterator<Map.Entry<Integer, Integer>> iterator;
  private Map.Entry<Integer, Integer> currEntry;
  private int index = 0;
  /** Get a random element from the collection. */
  public int getRandom() {
    if (iterator == null) {
      initIterator();
    }
    if (currEntry != null) {
      if (currEntry.getValue() > index) {
        index++;
        return currEntry.getKey();
      } else {
        if (!iterator.hasNext()) {
          initIterator();
        }
        currEntry = iterator.next();
        index = 1;
        return currEntry.getKey();
      }
    } else {
      currEntry = iterator.next();
      index = 1;
      return currEntry.getKey();
    }
  }
}
