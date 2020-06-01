package shuwei.leetcode.cn.eight.four;

import java.util.Stack;

public class Solution {

  // 使用stack优化, 8 ms, 95.48%
  public int largestRectangleArea(int[] heights) {
    int maxArea = 0;
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i <= heights.length; i++) {
      int currHeight;
      if (i == heights.length) {
        currHeight = -1;
      } else {
        currHeight = heights[i];
      }
      int prevIndex = this.getPrevIndex(stack);
      while (prevIndex >= 0) {
        int prevHeight = prevIndex == -1 ? -1 : heights[prevIndex];
        if (currHeight < prevHeight) {
          stack.pop();
          int ppIndex = this.getPrevIndex(stack);
          maxArea = Math.max(maxArea, (i - ppIndex - 1) * prevHeight);
          prevIndex = ppIndex;
        } else {
          break;
        }
      }
      stack.add(i);
    }
    return maxArea;
  }

  private int getPrevIndex(Stack<Integer> stack) {
    if (stack.isEmpty()) {
      return -1;
    } else {
      return stack.peek();
    }
  }

  // 暴力遍历高度,1144ms,ac
  public int largestRectangleArea2(int[] heights) {
    int maxArea = 0;
    for (int i = 0; i < heights.length; i++) {
      int left = i - 1, right = i + 1;
      while (true) {
        if (left >= 0 && heights[left] >= heights[i]) {
          left--;
        } else if (right < heights.length && heights[right] >= heights[i]) {
          right++;
        } else {
          break;
        }
      }
      maxArea = Math.max(maxArea, (right - left - 1) * heights[i]);
    }
    return maxArea;
  }

  // 暴力方法，760ms,能ac
  public int largestRectangleArea1(int[] heights) {
    int maxArea = 0;
    for (int i = 0; i < heights.length; i++) {
      int minHigh = heights[i];
      for (int j = i; j < heights.length; j++) {
        if (heights[j] < minHigh) {
          minHigh = heights[j];
        }
        if (minHigh == 0) {
          break;
        }
        if (maxArea / minHigh >= heights.length - i) {
          break;
        }
        int area = minHigh * (j - i + 1);
        maxArea = Math.max(maxArea, area);
      }
    }
    return maxArea;
  }
}
