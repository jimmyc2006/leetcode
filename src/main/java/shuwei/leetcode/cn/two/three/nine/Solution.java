package shuwei.leetcode.cn.two.three.nine;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution {
    /**
     * 方法1：
     * 使用PriorityQueue作为滑动窗口的内容的时候，会超时
     *
     * 方法2：
     * 有没有一种数据结构能处理这种不停的去头加尾巴的数据段的最大值呢？
     * 也就是一个数组，不停的使用一个新值替换里面的某一个值，能知道它的最大值
     * 如果从索引start开始，记录到end的最大值，那么从start到end + 1的最大值：
     * 其实就是查看当前这个值是否大于从start到end的最大值，如果比这个值大，则更新这个最大值
     * 用一个数组表示从start到end的最大值,那么这个数组的值该如何求解呢？
     * 这样的话，遇到一个新值就需要计算从i - k 到k的所有二维数组的最大值，感觉时间复杂度也不低
     * 方法2优化：
     * 只需要记录最近几次的最大值，滚动变化，但是感觉还不如重新计算一次来的方便和快捷
     *
     * 方法3：
     * 上面的方式似乎有点不太对，因为只有当被拿出的数值是之前的最大值，且比当前要加入的值大的时候，才需要重新计算大小
     * 否则，可以直接使用当前值与之前的最大值作为本次的结果，如果遇到例外，直接重新计算最大值，试试,60/60超时，这种对于降序排列的数组，效率非常的低
     *
     * 如果我用一个双向链表来代替stack，来表示某段数值的最大值
     * 例如： LinkedList
     * 1, 3, -1, -3, 5, 3, 6, 7  k=3的时候
     * 1,3，-1 的时候，最大值分别为 1, 3, 3 但是这样的最后这个3无法使用
     * 如果反着算，7,7,7,6;我觉得可能有一种成型的算法来解决这种问题，但是我没有想出来,可能是知识面不够
     *
     *
     * @param nums
     * @param k
     * @return
     */

    /**
     * 官方思路3：预先计算法，思路：先将原来的数组按照每k个成员分组，最后一个组的数量可能小于k
     * 分别对每个组计算最大值，由于当前计算的分组，可能仅包含某个相邻的2个组：
     * 分别是某个分割点前面的部分，和它后面的部分，那么就需要计算每个分割点的前缀和后缀最大值
     * pre和suf表示，那么它们的下标应该是k的1倍开始
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int[][] pre = new int[length / k][k + 1];
        int[][] suf = new int[length / k][k + 1];

        int curMax = Integer.MIN_VALUE;
        // 每个点往前计算pre
        /**
         * 用3个数，2长度做比较，需要求下标为1时候的pre,下标分别为0
         */
        for (int i = 0 ; i < pre.length; i++) {
            curMax = Integer.MIN_VALUE;
            for (int j = 1; j < k; j++) {
                curMax = Math.max(curMax, nums[k * (i + 1) - j]);
                pre[i][j - 1] = curMax;
            }
        }
        // 计算最终的结果
        int[] ans = new int[length + 1 - k];
        curMax = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            curMax = Math.max(curMax, nums[i]);
            int curLength = i + 1;
            if (curLength % k ==0) {
                ans[curLength - k] = curMax;
                curMax = Integer.MIN_VALUE;
            } else {
                if (curLength > k) {
                    int kIndex = curLength / k - 1;
                    // 往后的坐标是对k取余，某个点位往前时候已经包含的它自己，那么往后的时候就不用包含它自己了
                    suf[kIndex][curLength % k] = curMax;
                    // 前缀和后缀中比较大的那一个值,往前的坐标是k - 开始位置对k取余
                    // 如果k是2，那么计算到下标2的时候，以下标1为计算点， 应该计算的是pre[0][0], suf[0][1]
                    ans[curLength - k] = Math.max(pre[kIndex][k - 1 - curLength % k], suf[kIndex][curLength % k]);
                } else {
                    curMax = Math.max(curMax, nums[i]);
                }
            }
        }
        return ans;
    }

    /**
     * 单调队列，官方思路,重要解法
     * 从左往右计算，借助排序栈的思路，因为前面去掉的元素跟下标有关，所以需要使用下标放入堆栈
     * 还有一个特征，之前没有注意到，就是当访问到第i个元素的时候，这个元素会屏蔽之前比它小的所有元素
     * 那么可以使用一个队列，保存从大到小的数值的下标，例如{1, 3, -1, -3, -2， 5, 3, 6, 7}, 3
     * 先保存的下标0到queue中，遇到3的时候，发现queue中前面有比3小的1，那么直接将1丢弃，把3的下标1放入queue
     * -1的时候，比3小，那么直接放入queue，-3的时候也直接放入queue，此时queue中有3个值，分别是1,2,3
     * 下一个-2的时候，将-3丢弃，将-2的下标放入
     * 取结果的时候，需要将队列头部中的下标小于当前正在赋值的下标的丢弃
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindowGF2(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        int length = nums.length;
        // 如果数组有3个值，k是2的话，那么结果应该有2个值
        int[] ans = new int[length + 1 - k];
        for (int i = 0; i < length; i++) {
            while(queue.size() > 0 && nums[queue.peekLast()] < nums[i]){
                queue.pollLast();
            }
            queue.addLast(i);
            int curLength = i + 1;
            if (curLength >= k) {
                int startIndex = curLength - k;
                while(queue.size() > 0 && queue.peekFirst() < startIndex) {
                    queue.pollFirst();
                }
                ans[startIndex] = nums[queue.peekFirst()];
            }
        }
        return ans;
    }

    /**
     * 题解以后的思路，是优先队列中的数值如果不影响结果，可以不用每次都remove，这样可以节省一些remove的时间
     * 但是感觉可能会使add时间变慢，但是从执行结果来看，这个是能通过测试的
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindowGF1(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

    // 60/60超时时间限制是什么鬼
    public int[] maxSlidingWindow3(int[] nums, int k) {
        int[] ans = new int[nums.length + 1 - k];
        int currMax = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int currLength = i + 1;
            if (currLength > k) {
                if (nums[i] >= currMax) {
                    currMax = nums[i];
                } else {
                    int removeValue = nums[currLength - k - 1];
                    if (removeValue == currMax) {
                        currMax = nums[currLength - k];
                        for (int j = currLength - k + 1; j <= i; j++) {
                            currMax = Math.max(currMax, nums[j]);
                        }
                    }
                }
            } else {
                currMax = Math.max(currMax, nums[i]);
            }
            if (currLength >= k) {
                ans[currLength - k] = currMax;
            }
        }
        return ans;
    }

    // 47的时候，超时了
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int length = nums.length;
        int[][] dp = new int[length][length];
        int[] ans = new int[nums.length + 1 - k];
        for (int i = 0; i < nums.length; i++) {
            int curLength = i + 1;
            int j = curLength - k > 0 ? curLength - k : 0 ;
            for (; j <= i; j++) {
                if (j == i){
                    dp[j][i] = nums[j];
                } else {
                    dp[j][i] = Math.max(dp[j][i - 1], nums[i]);
                }
            }
            if (curLength >= k) {
                ans[curLength - k] = dp[curLength - k][i];
            }
        }
        return ans;
    }

    // 49的时候，超时了
    public int[] maxSlidingWindow1(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int[] ans = new int[nums.length + 1 - k];
        for (int i = 0; i < nums.length; i++) {
            int t = i + 1;
            if (t >= k) {
                queue.add(nums[i]);
                ans[t - k] = queue.peek();
                queue.remove(nums[t - k]);
            } else {
                queue.add(nums[i]);
            }
        }
        return ans;
    }
}
