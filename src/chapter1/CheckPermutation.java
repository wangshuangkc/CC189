package chapter1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings, write a method to decide if one is a permutation of the other
 *
 * Questions
 * 1. Definition: two strings have the same characters but in different order
 */
public class CheckPermutation {
  private static final int ASCII_SIZE = 128;

  // Time: O(N) Space: O(1)
  public static boolean checkPermutation_ascii(String str1, String str2) {
    if (isBlank(str1) || isBlank(str2) || str1.length() != str2.length() || str1.equals(str2)) {
      return false;
    }

    int[] chars = new int[ASCII_SIZE];
    for (int c : str1.toCharArray()) {
      chars[c] += 1;
    }

    for (int c : str2.toCharArray()) {
      if (chars[c] == 0) {
        return false;
      }

      chars[c]--;
    }

    for (int i : chars) {
      if (chars[i] > 0) {
        return false;
      }
    }

    return true;
  }

  // Time: O(NlogN) Space O(N)
  public static boolean checkPermutation_sort(String str1, String str2) {
    if (isBlank(str1) || isBlank(str2) || str1.length() != str2.length() || str1.equals(str2)) {
      return false;
    }

    char[] chars1 = str1.toCharArray();
    char[] chars2 = str2.toCharArray();
    Arrays.sort(chars1);
    Arrays.sort(chars2);

    return chars1.toString().equals(chars2.toString());
  }

  // Time: O(N) Space: O(N)
  public static boolean checkPermutation_hash(String str1, String str2) {
    Map<Character, Integer> chars = new HashMap<>();
    for (char c : str1.toCharArray()) {
      if (!chars.containsKey(c)) {
        chars.put(c, 1);
      } else {
        chars.put(c, chars.get(c)+1);
      }
    }

    for(char c : str2.toCharArray()) {
      if (!chars.containsKey(c) || chars.get(c) == 0) {
        return false;
      }

      chars.put(c, chars.get(c) + 1);
    }

    return false;
  }

  private static boolean isBlank(String str) {
    return str == null || str.length() == 0;
  }
}
