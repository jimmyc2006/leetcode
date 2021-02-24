package shuwei.leetcode.cn;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.junit.Assert;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

public class TestUtil {

  public static int[][] readTwoArrayFromFile(String fileName) {
    if (! fileName.startsWith("/")) {
      fileName = "/Users/shuwei/Desktop/" + fileName;
    }
    Gson gson = new GsonBuilder().create();
    Type type = new TypeToken<List<List<Integer>>>() {
    }.getType();
    Reader reader = null;
    try {
      reader = new FileReader(new File(fileName));
      Object o = gson.fromJson(reader, type);
      List<List<Integer>> lists = (List<List<Integer>>) o;
      int ans[][] = new int[lists.size()][];
      for (int i = 0; i < lists.size(); i++) {
        List<Integer> innerList = lists.get(i);
        ans[i] = new int[innerList.size()];
        for (int j = 0; j < innerList.size(); j++) {
          ans[i][j] = innerList.get(j);
        }
      }
      return ans;
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        reader.close();
      } catch (IOException e) {
      }
    }
    return null;
  }

  public static int[] readArrayFromFile(String fileName) {
    if (! fileName.startsWith("/")) {
      fileName = "/Users/shuwei/Desktop/" + fileName;
    }
    Gson gson = new GsonBuilder().create();
    Type type = new TypeToken<List<Integer>>() {
    }.getType();
    Reader reader = null;
    try {
      reader = new FileReader(new File(fileName));
      Object o = gson.fromJson(reader, type);
      List<Integer> lists = (List<Integer>) o;
      int ans[] = new int[lists.size()];
      for (int i = 0; i < lists.size(); i++) {
        ans[i] = lists.get(i);
      }
      return ans;
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        reader.close();
      } catch (IOException e) {
      }
    }
    return null;
  }

  public static void assertArraysEquals(int[][] ar1, int[][] ar2) {
    Assert.assertEquals(ar1.length, ar2.length);
    for (int i = 0; i < ar1.length; i++) {
      Assert.assertArrayEquals(ar1[i], ar2[i]);
    }
  }
}
