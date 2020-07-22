package shuwei.leetcode.cn.one.two.four.eight;

import java.sql.*;

public class Solution {
  public static void main(String[] args) throws Exception {
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://10.10.10.72:3306/hive_meta?characterEncoding=utf-8","hive","hive123");
    Statement stmt = conn.createStatement();
    String sql;
    sql = "SELECT * FROM sw_test_vb";
    ResultSet rs = stmt.executeQuery(sql);
    while(rs.next()) {
      System.out.println(rs.getInt(1));
      rs.getString(1);
      System.out.println(new String(rs.getBytes(2)));
      System.out.println("-------------------------------");
    }
  }
  
  public int numberOfSubarrays(int[] nums, int k) {
    int[] oddIndex = new int[nums.length];
    int oddLength = 0;
    for (int i = 0; i < nums.length; i++){
      if (nums[i] % 2 == 1) {
        oddIndex[oddLength++] = i;
      }
    }
    if (oddLength < k) {
      return 0;
    }
    int start = -1, mathStart = 0, matchEnd = k - 1;
    int ans = 0;
    while (matchEnd < oddLength) {
      int nextEnd;
      if (matchEnd + 1 < oddLength) {
        nextEnd = oddIndex[matchEnd + 1];
      } else {
        nextEnd = nums.length;
      }
      ans += (oddIndex[mathStart] - start) * (nextEnd - oddIndex[matchEnd]);
      start = oddIndex[mathStart++];
      matchEnd++;
    }
    return ans;
  }
}
