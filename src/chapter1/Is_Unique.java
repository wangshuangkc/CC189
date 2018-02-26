package chapter1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use extra data structure
 *
 * Questions
 * 1. ASCII (128 or 256) or UniCode
 * 2. Time and space complexity
 * 3. Modify the string
 */
public class Is_Unique {

  // Time: O(N) Space: O(N)
  public boolean isUnique_hashTable(String str) {
    Map<Character, Character> map = new HashMap<>();
    for (char s : str.toCharArray()) {
      if(map.containsKey(s)) {
        return false;
      }

      map.put(s, s);
    }

    return true;
  }

  // Time: O(N) Space: O(1)
  public boolean isUnique_ascii128(String str) {
    if (str.length() > 128) {
      return false;
    }

    boolean[] char_set = new boolean[128];
    for (int i = 0; i < str.length(); i++) {
      int c = str.charAt(i);
      if (char_set[c]) {
        return false;
      }

      char_set[c] = true;
    }

    return true;
  }

  // Time: O(N^2) Space: O(1)
  public boolean isUnique_noDataStructure(String str) {
    char[] chars = str.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      char c = chars[i];
      for (int j = i + 1; j < chars.length; j++) {
        if (chars[j] == c) {
          return false;
        }
      }
    }
    return true;
  }

  // Time: O(N) Space: O(N)
  public boolean isUnique_bitVector(String str) {
    int checker = 0;
    for (int i = 0; i < str.length(); i++) {
      int val = str.charAt(i) - 'a';
      if ((checker & (1 << val)) > 0) {
        return false;
      }
      checker |= 1 << val;
    }

    return true;
  }

  // Time: O(NlogN) Space: O(N)
  public boolean isUnique_sorted(String str) {
    char[] chars = str.toCharArray();
    // ToDo sort in O(NlogN) without extra space
    Arrays.sort(chars);

    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == chars[i + 1]) {
        return false;
      }
    }

    return true;
  }
}
