import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shuwei
 * @version 创建时间：2017年9月15日 下午9:01:23 类说明
 */
public class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Integer> mapB = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            mapB.put(B[i], i);
        }
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            result[i] = mapB.get(A[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] res = s.anagramMappings(new int[] {12, 28, 46, 32, 50}, new int[] {50, 12, 32,
                46, 28});
        for(int i = 0; i < res.length; i++) {
            System.out.println(i + ":" + res[i]);
        }
    }
}
