package shuwei.leetcode.cn.one.four.three.eight;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Solution {

  /**
   * 题解：滑动窗口+单调队列
   */
  public int longestSubarray(int[] nums, int limit) {
    int length = nums.length;
    Deque<Integer> minQueue = new LinkedList<>();
    Deque<Integer> maxQueue = new LinkedList<>();
    int left = 0, right = 0;
    int ans = 1;
    while (right < length) {
      int curr = nums[right];
      while (minQueue.size() > 0 && minQueue.peekLast() > curr) {
        minQueue.pollLast();
      }
      while (maxQueue.size() > 0 && maxQueue.peekLast() < curr) {
        maxQueue.pollLast();
      }
      minQueue.addLast(curr);
      maxQueue.addLast(curr);
      if (maxQueue.peekFirst() - minQueue.peekFirst() > limit) {
        ans = Math.max(ans, right - left);
        while (maxQueue.size() > 0 && minQueue.size() > 0 &&
                maxQueue.peekFirst() - minQueue.peekFirst() > limit) {
          if (minQueue.peekFirst() == nums[left]) {
            minQueue.pollFirst();
          }
          if (maxQueue.peekFirst() == nums[left]) {
            maxQueue.pollFirst();
          }
          left++;
        }
      }
      right++;
    }
    return Math.max(ans, length - left);
  }

  /**
   * 题解： 滑动窗口+有序集合
   */
  // 2021-02-22 review
  // 这个思路比较简单，按说应该最先想到 64ms
  public int longestSubarray3(int[] nums, int limit) {
    int ans = 1;
    TreeMap<Integer, Integer> counts = new TreeMap<>();
    int left = 0, right = 0;
    while (right < nums.length) {
      Integer integer = counts.get(nums[right]);
      if (integer == null) {
        counts.put(nums[right], 1);
      } else {
        counts.put(nums[right], integer + 1);
      }
      if (counts.lastKey() - counts.firstKey() > limit) {
        ans = Math.max(ans, right - left);
        while (counts.lastKey() - counts.firstKey() > limit) {
          Integer val = counts.get(nums[left]);
          if (val == 1) {
            counts.remove(nums[left]);
          } else {
            counts.put(nums[left], val - 1);
          }
          left++;
        }
      }
      right++;
    }
    return Math.max(ans, nums.length - left);
  }

  /**
   * 该用简单思路滑动窗口　46 ms
   */
  public int longestSubarray2(int[] nums, int limit) {
    int left = 0, ans = 1;
    int min = nums[0], max = nums[0];
    int minIndex = 0, maxIndex = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > max) {
        max = nums[i];
        maxIndex = i;
        if (max - min > limit) {
          ans = Math.max(ans, i - left);
          int[] nextLeft = findNextLeft(nums, minIndex, i, max, limit, true);
          left = nextLeft[0];
          minIndex = nextLeft[1];
          min = nextLeft[2];
        }
      } else if (nums[i] < min) {
        min = nums[i];
        minIndex = i;
        if (max - min > limit) {
          ans = Math.max(ans, i - left);
          int[] nextLeft = findNextLeft(nums, maxIndex, i, min, limit, false);
          left = nextLeft[0];
          maxIndex = nextLeft[1];
          max = nextLeft[2];
        }
      }
    }
    return Math.max(ans, nums.length - left);
  }

  private int[] findNextLeft(int[] arr, int left, int end, int num, int limit, boolean bigger) {
    int res = left + 1;
    int estIndex = res;
    int estValue = arr[res];
    for (int i = left + 1; i <= end; i++) {
      if (bigger) {
        if (arr[i] < num - limit) {
          res = i + 1;
          estIndex = res;
          estValue = arr[res];
        } else {
          if (arr[i] < estValue) {
            estIndex = i;
            estValue = arr[i];
          }
        }
      } else {
        if (arr[i] - num > limit) {
          res = i + 1;
          estIndex = res;
          estValue = arr[res];
        } else {
          if (arr[i] > estValue) {
            estIndex = i;
            estValue = arr[i];
          }
        }
      }
    }
    return new int[]{res, estIndex, estValue};
  }

  /**
   * 62 ms 滑动窗口记录left和right 额外记录最小值和它的索引，最大值和它的索引 当范围不满足limit的时候，如果因为最小值的原因，那么就让left变为最小值右边的索引
   * 需要更新最小值和它的索引，这个问题不好处理，每次换left的时候，min和max都会变 使用2个优先队列保存最小值和最大值，弹出最小值以后，检查后面的最小值的索引，如果在left和right范围内就变为当前最小值
   * 这种算法有漏洞遇到2,2,2,4,4,2,5,5,5,5,5,2的时候出问题，后面的2会被漏掉，然后从4开始 需要改进一下，每次弹出的时候记录left
   */
  public int longestSubarray1(int[] nums, int limit) {
    PriorityQueue<int[]> minP = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    });
    PriorityQueue<int[]> maxP = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o2[0] - o1[0];
      }
    });
    int left = 0;
    int ans = 1;
    minP.add(new int[]{nums[0], 0});
    maxP.add(new int[]{nums[0], 0});
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > maxP.peek()[0]) {
        if (nums[i] - minP.peek()[0] > limit) {
          ans = Math.max(ans, i - left);
          left++;
          while (minP.size() > 0 && (minP.peek()[1] < left || nums[i] - minP.peek()[0] > limit)) {
            left = Math.max(left, minP.poll()[1] + 1);
          }
          while (maxP.size() > 0 && maxP.peek()[1] < left) {
            maxP.poll();
          }

        }
      } else if (nums[i] < minP.peek()[0]) {
        if (maxP.peek()[0] - nums[i] > limit) {
          ans = Math.max(ans, i - left);
          left++;
          while (maxP.size() > 0 && (maxP.peek()[1] < left || maxP.peek()[0] - nums[i] > limit)) {
            left = Math.max(left, maxP.poll()[1] + 1);
          }
        }
        while (minP.size() > 0 && minP.peek()[1] < left) {
          minP.poll();
        }
      }
      minP.add(new int[]{nums[i], i});
      maxP.add(new int[]{nums[i], i});
    }
    return Math.max(ans, nums.length - left);
  }

}
