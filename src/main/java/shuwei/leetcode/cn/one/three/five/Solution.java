package shuwei.leetcode.cn.one.three.five;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  /**
   * 分发糖果 1，0，2 结果是212是5 1，2，2 结果是121是4 从第0开始遍历，设置当前糖果为1，遍历到1的时候： 如果1比0大，那么1的糖果为0的糖果数+1
   * 如果1的糖果比0的小，那么1的糖果设置为1，从1往前遍历，只要递增的都+1 如果1等于0，那么糖果数直接设置为1即可 这样算法复杂度可能会到n^2
   *
   * 思路2： 先找到这样的点，它的左边和右边都是大于等于它，设置为1 然后再从左向右遍历，遇到1开始计算如果数值增大就+1，否则不计算
   * 然后再从右往左遍历，也是遇到1开始计算变大就数值+1，该位置的值等于当前值和算出来的值取大的
   *
   * 思路3： 跟思路1有点像，从左往右遍历，假设0位置的值为1，如果1位置变大了，那么当前值变为2，结果+2 如果继续增加，那么当前值变为3，结果+3 如果遇到相同的，那么直接设置为1，结果+1
   * 如果遇到变小的，那么结果不增加，当前值不变，记录递减数量1 如果再变小，那么结果不增加，当前值不变，记录递减数量+1 如果相同或者变大了，那么该数就是低谷：
   * 如果此时当前值大于递减数量，那么结果+从1到递减数量的和， 如果此时当前值小于递减数量，那么结果+从1到递减数量+1的和，然后再减一个当前值
   *
   * 思路4：看过题解的思路，记录上升的长度，下降的长度，当由于下降转为上升的啥时候，比较上一个上升的长度和当前下降的长度，如果下降长度大于上一个上升的长度，需要补齐
   */

  public int candy(int[] ratings) {
    if (ratings == null || ratings.length < 1) {
      return 0;
    }
    if (ratings.length == 1) {
      return 1;
    }
    int ans = 1;
    int up = 1;
    int down = 0;
    int curr = 1;
    for (int i = 1; i < ratings.length; i++) {
      if (ratings[i] >= ratings[i - 1]) {
        down = 0;
        curr = ratings[i] == ratings[i - 1] ? 1: curr + 1;
        ans += curr;
        up = curr;
      } else {
        down++;
        if (up == down) {
          down++;
        }
        ans += down;
        curr = 1;
      }
    }
    return ans;
  }

//  public int candy(int[] ratings) {
//    if (ratings == null || ratings.length < 1) {
//      return 0;
//    }
//    if (ratings.length == 1) {
//      return 1;
//    }
//    int ans = 1;
//    int last = 1;
//    boolean isUp = true;
//    int curr = 1;
//    // 1, 3, 2, 2, 1
//    for (int i = 1; i < ratings.length; i++) {
//      if (ratings[i] > ratings[i - 1]) {
//        // 如果当前值比上一个值大，递减积分增加
//        if (isUp) {
//          curr++;
//        } else {
//          // 前面是底
//          if (last < curr + 1) {
//            ans += curr + 1 - last;
//          }
//          curr = 2;
//          isUp = true;
//        }
//        last = curr;
//      } else if (ratings[i] < ratings[i - 1]) {
//        // 如果当前值比上一个值小，可能是谷底，也可能是山坡
//        if (isUp) {
//          isUp = false;
//          curr = 1;
//        } else {
//          curr++;
//        }
//      } else {
//        if (!isUp) {
//          if (last < curr + 1) {
//            ans += curr + 1 - last;
//          }
//        }
//        curr = 1;
//        last = curr;
//        isUp = true;
//      }
//      ans += curr;
//    }
//    if (!isUp && curr + 1 > last) {
//      ans += curr + 1 - last;
//    }
//    return ans;
//  }

//  public int candy(int[] ratings) {
//    if (ratings == null || ratings.length < 1) {
//      return 0;
//    }
//    if (ratings.length == 1) {
//      return 1;
//    }
//    int[] result = new int[ratings.length];
//    List<Integer> oneIndexs = new ArrayList<>();
//    if (ratings[0] <= ratings[1]) {
//      result[0] = 1;
//      oneIndexs.add(0);
//    }
//    if (ratings[ratings.length - 1] <= ratings[ratings.length - 2]) {
//      result[ratings.length - 1] = 1;
//      oneIndexs.add(ratings.length - 1);
//    }
//    for (int i = 1; i < ratings.length - 1; i++) {
//      if (ratings[i] <= ratings[i - 1] && ratings[i] <= ratings[i + 1]) {
//        result[i] = 1;
//        oneIndexs.add(i);
//      }
//    }
//    // 从每一个点往两边扩散，直到不是递增的即可不用处理
//    for(int i = 0; i < oneIndexs.size(); i++) {
//      int left = oneIndexs.get(i);
//      int right = left;
//      int curr = 1;
//      while(left - 1 >= 0 &&  ratings[left - 1] > ratings[left]) {
//        result[left - 1] = Math.max(++curr, result[left - 1]);
//        left--;
//      }
//      curr = 1;
//      while(right + 1 < ratings.length && ratings[right + 1] > ratings[right]) {
//        result[right + 1] = Math.max(++curr, result[right + 1]);
//        right++;
//      }
//    }
//    return Arrays.stream(result).sum();
//  }

//  public int candy2(int[] ratings) {
//    if (ratings == null || ratings.length < 1) {
//      return 0;
//    }
//    if (ratings.length == 1) {
//      return 1;
//    }
//    int[] result = new int[ratings.length];
//    if (ratings[0] <= ratings[1]) {
//      result[0] = 1;
//    }
//    if (ratings[ratings.length - 1] <= ratings[ratings.length - 2]) {
//      result[ratings.length - 1] = 1;
//    }
//    for (int i = 1; i < ratings.length - 1; i++) {
//      if (ratings[i] <= ratings[i - 1] && ratings[i] <= ratings[i + 1]) {
//        result[i] = 1;
//      }
//    }
//    int curr = 1;
//    for (int i = 1; i < ratings.length; i++) {
//      if (result[i] == 1) {
//        curr = 1;
//      } else if (ratings[i] > ratings[i - 1]) {
//        result[i] = ++curr;
//      }
//    }
//    curr = 1;
//    for (int i = ratings.length - 2; i >= 0; i--) {
//      if (result[i] == 1) {
//        curr = 1;
//      } else if(ratings[i] > ratings[i + 1]) {
//        result[i] = Math.max(result[i], ++curr);
//        curr = result[i];
//      }
//    }
//    return Arrays.stream(result).sum();
//  }
//
//  public int candy1(int[] ratings) {
//    if (ratings == null || ratings.length < 1) {
//      return 0;
//    }
//    int[] result = new int[ratings.length];
//    result[0] = 1;
//    for (int i = 1; i < ratings.length; i++) {
//      if (ratings[i] == ratings[i - 1]) {
//        result[i] = 1;
//      } else if (ratings[i] > ratings[i - 1]) {
//        result[i] = result[i - 1] + 1;
//      } else {
//        result[i] = 1;
//        int j = i - 1;
//        while (j >= 0 && ratings[j] > ratings[j + 1]) {
//          if (result[j] <= result[j + 1]) {
//            result[j] = result[j + 1] + 1;
//          }
//          j--;
//        }
//      }
//    }
//    return Arrays.stream(result).sum();
//  }
}
