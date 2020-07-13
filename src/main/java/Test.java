import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i< 6; i++){
            System.out.println(i + 1);
            Thread.sleep( 10000);
        }
    }
    public String convert(String s, int numRows) {
        if (numRows < 2 || s.length() == 0) {
            return s;
        }
        int len = s.length();
        int interval = numRows * 2 - 2;
        int k = 0;
        char[] chars = new char[len];

        // first line
        for (int i = 0; i < len; i += interval) {
            chars[k++] = s.charAt(i);
        }

        // middle line
        for (int row = 1; row < numRows - 1; row++) {
            // row => +(interval–2*row) | +(2*row) | +(interval–2*row) | +(2*row) |
            int midInterval = 2 * row;
            for (int i = row; i < len; i += midInterval) {
                chars[k++] = s.charAt(i);
                // 1-> interval–2*row
                // 2-> interval–(interval–2*row) = 2*row
                midInterval = interval - midInterval;
            }
        }

        // last line
        for (int i = numRows - 1; i < len; i += interval) {
            chars[k++] = s.charAt(i);
        }
        return new String(chars);

    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    result.add(Arrays.asList(-target, nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum > target) {
                    right--;
                } else { // sum < target
                    left++;
                }
            }
        }
        return result;
    }
}
