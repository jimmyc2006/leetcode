package shuwei.leetcode.cn.seven.zero.three;

public class KthLargest {
    /*
    // 12 ms
    int[] heap;
    // 堆实际大小
    int size;
    // 堆的最大容量
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        heap = new int[k+1];

        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        if (size < k) {
            heap[++size] = val;
            swim(size);
        } else if (val > heap[1]) {
            heap[1] = val;
            sink(1);
        }
        return heap[1];
    }

    // 上浮
    private void swim(int index) {
        int parent;
        while (index > 1) {
            parent = index/2;
            if (heap[parent] > heap[index]) {
                exchange(heap, parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    // 下沉
    private void sink(int index) {
        // 左孩子的下标
        int targetIndex;
        while (index * 2 <= size) {
            targetIndex = index * 2;
            // 如果右孩子的下标在范围内，且左孩子比右孩子大；则右孩子更小，我们更右孩子交换
            if (targetIndex + 1 <= size  && heap[targetIndex] > heap[targetIndex + 1]) {
                targetIndex++;
            }
            if (heap[targetIndex] >= heap[index]) {
                break;
            }
            exchange(heap, index, targetIndex);
            index = targetIndex;
        }
    }

    private void exchange(int[] heap, int i, int j) {
        int temp = heap[j];
        heap[j] = heap[i];
        heap[i] = temp;
    }
*/
    // 18 ms------------------
    private RollPriorityQueue rollPriorityQueue;

    public KthLargest(int k, int[] nums) {
        rollPriorityQueue = new RollPriorityQueue(k);
        for (int num : nums) {
            rollPriorityQueue.add(num);
        }
    }

    public int add(int val) {
        return rollPriorityQueue.add(val);
    }
    // 18 ms------------------

    /**
     * 这个并不快241ms
     * @param k
     * @param nums
     */
//    public KthLargest(int k, int[] nums) {
//        stack = new int[k];
//        this.k = k;
//        for (int num : nums) {
//            this.add(num);
//        }
//    }
//
//    private int[] stack;
//    private int curr = 0;
//    private int k;
//
//    public int add(int val) {
//        if (curr < k) {
//            stack[curr++] = val;
//            if (curr == k) {
//                pop();
//            }
//        } else {
//            if (val > stack[0]) {
//                stack[0] = val;
//                pop();
//            }
//        }
//        return stack[0];
//    }
//
//    /**
//     * 优化了pop以后，还是108ms
//     */
//    private void pop() {
//        int minIndex = 0;
//        for (int i = 1; i < stack.length; i++) {
//            if (stack[i] < stack[minIndex]) {
//                minIndex = i;
//            }
//        }
//        int tmp = stack[0];
//        stack[0] = stack[minIndex];
//        stack[minIndex] = tmp;
//    }

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
