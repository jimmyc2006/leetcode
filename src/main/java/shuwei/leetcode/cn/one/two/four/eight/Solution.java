package shuwei.leetcode.cn.one.two.four.eight;

/**
 * @author shuwei
 * @version 创建时间：2020年4月21日 下午3:51:41 类说明
 */
public class Solution {
  // 借鉴别人的代码，拿过来看一下流程
  public int numberOfSubarrays1(int[] nums, int k) {
    int len = nums.length;
    int res = 0;
    int oddCount = 0;
    int arr[] = new int[len + 2];
    // 记录第oddCount个奇数的下标
    for (int i = 0; i < len; i++) {
      if ((nums[i] & 1) == 1) {
        arr[++oddCount] = i;// 第++oddCount个奇数的下标是i
      }
    }
    arr[0] = -1;// 左边界
    arr[oddCount + 1] = len;// 右边界

    // arr[i]是窗口左边界
    // arr[i+k-1] 是窗口右边界
    // arr[i-1]是左边的上一个奇数，在此之后到arr[i]都可选
    // arr[i+k]是右边的下一个奇数，在此之前都arr[i+k-1]都可选
    // 前面可选部分长度为arr[i]-arr[i-1]
    // 后面可选部分长度为arr[i+k]-arr[i+k-1]
    // 总的可能数等于前后可选的组合

    for (int i = 1; i + k < oddCount + 2; i++) {
      res += (arr[i] - arr[i - 1]) * (arr[i + k] - arr[i + k - 1]);
    }
    return res;
  }

  // 开始没使用arr，使用ArrayList的时候，这个方法执行时间28ms，时间打败23%
  // 后来将ArrayList改为arr以后，耗时5毫秒，打败97%用户
  // 总结：对于性能要求高的代码，能使用数组的时候尽量不使用集合类
  // 查询题解后发现思路是对的，但是提炼的公式不够简单直接
  public int numberOfSubarrays(int[] nums, int k) {
    int[] arr = new int[nums.length + 2];
    arr[0] = -1;
    int oddCount = 0;
    for (int i = 0; i < nums.length; i++) {
      if ((nums[i] & 1) == 1) {
        arr[++oddCount] = i;
      }
    }
    arr[++oddCount] = nums.length;
    int result = 0;
    for (int i = 1; i + k < oddCount + 1; i++) {
      result += (arr[i] - arr[i - 1]) * (arr[i + k] - arr[i + k - 1]);
    }
    return result;
  }
}
