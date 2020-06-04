package shuwei.leetcode.cn.one.one;

/**
 * @author shuwei
 * @version 创建时间：2020年4月18日 下午7:26:11 类说明
 */
public class Solution {

  // ------ 6.1 双指针,从两边往中间运动，谁小谁动，因为如果移动大的，不可能出现更大的容积
  public int maxArea(int[] height) {
    int ans = 0;
    for (int i =0, j = height.length - 1; i < j;) {
      if (height[i] > height[j]) {
        ans = Math.max(ans, height[j] * (j - i));
        j--;
      } else {
        ans = Math.max(ans, height[i] * (j - i));
        i++;
      }
    }
    return ans;
  }
  // ------ 上面是6.1复习
  
  // 看了双指针之后的思路
  public int maxArea2(int[] height) {
    int maxArea = 0;
    for (int i = 0, j = height.length - 1; i < j;) {
      int area = Math.min(height[i], height[j]) * (j - i);
      if (area > maxArea) {
        maxArea = area;
      }
      if (height[i] < height[j]) {
        i++;
      } else if (height[i] > height[j]) {
        j--;
      } else {
        i++;
        j--;
      }
    }
    return maxArea;
  }
  
  // 这个方法虽然能通过测试，但是运行90ms，只能打败32%用户
  // 这个方法形成了思维定势，没有能找到比较好的解
  public int maxArea1(int[] height) {
    int maxLeft = -1;
    int maxResult = -1;
    for (int i = 0; i < height.length - 1; i++) {
      if (height[i] > maxLeft) {
        maxLeft = height[i];
        int maxRight = -1;
        int minJ = i;
        if (maxResult > 0) {
          if (maxResult > height[i] * (height.length - i)) {
            return maxResult;
          }
          minJ = Math.max(minJ, maxResult / height[i]);
        }
        for (int j = height.length - 1; j > minJ; j--) {
          if (height[j] > maxRight) {
            maxRight = height[j];
            int result = (j - i) * Math.min(height[i], height[j]);
            if (result > maxResult) {
              maxResult = result;
            }
          }
        }
      }
    }
    return maxResult;
  }
}
