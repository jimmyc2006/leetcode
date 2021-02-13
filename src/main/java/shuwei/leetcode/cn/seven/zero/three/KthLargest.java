package shuwei.leetcode.cn.seven.zero.three;

public class KthLargest {

    /**
     * 这个并不快241ms
     * @param k
     * @param nums
     */
    public KthLargest(int k, int[] nums) {
        stack = new int[k];
        this.k = k;
        for (int num : nums) {
            this.add(num);
        }
    }

    private int[] stack;
    private int curr = 0;
    private int k;

    public int add(int val) {
        if (curr < k) {
            stack[curr++] = val;
            if (curr == k) {
                pop();
            }
        } else {
            if (val > stack[0]) {
                stack[0] = val;
                pop();
            }
        }
        return stack[0];
    }

    private void pop() {
        for (int i = 1; i < stack.length; i++) {
            if (stack[i] < stack[0]) {
                int tmp = stack[0];
                stack[0] = stack[i];
                stack[i] = tmp;
            }
        }
    }

    /**
     * 21ms
     */
//    public KthLargest(int k, int[] nums) {
//        this.size = k;
//        queue = new PriorityQueue<>(k);
//        for (int num : nums) {
//            this.add(num);
//        }
//    }
//
//    private int size;
//    PriorityQueue<Integer> queue;
//
//    public int add(int val) {
//        if (queue.size() >= size) {
//            Integer peek = queue.peek();
//            if (peek < val) {
//                queue.poll();
//                queue.add(val);
//            }
//        } else {
//            queue.add(val);
//        }
//        return queue.peek();
//    }
}
