package chapter1;

/**
 * Three edit types: insert, remove or replace a character. Check if two strings are one edit away.
 */
public class OneAway {

  // Time: O(N) Space: O(1)
  public static boolean isOneEdit_3pass(String str1, String str2) {
    if (str1 == null || str2 == null || Math.abs(str1.length() - str2.length()) > 1) {
      return false;
    }
    if (str1.equals(str2)) {
      return true;
    }

    int len1 = str1.length();
    int len2 = str2.length();

    if (len1 == len2) {
      int edit = 0;
      for (int i = 0; i < len1; i++) {
        if (str1.charAt(i) != (str2.charAt(i)) && ++edit > 1) {
          return false;
        }
      }

      return true;
    }

    if (len1 > len2) {
      return isOneMore(str1, str2);
    }

    return isOneMore(str2, str1);
  }

  private static boolean isOneMore(String longer, String shorter) {
    int edit = 0;
    int j = 0;
    for (int i = 0; i < shorter.length();) {
      if (shorter.charAt(i) == longer.charAt(j)) {
        i++;
      } else if(++edit > 1) {
        return false;
      }
      j++;
    }

    return true;
  }

  // Time: O(N) Space: O(1)
  public static boolean isOneEdit_1pass(String str1, String str2) {
    if (str1 == null || str2 == null || Math.abs(str1.length() - str2.length()) > 1) {
      return false;
    }
    if (str1.equals(str2)) {
      return true;
    }

    boolean edited = false;
    int i = 0;
    int j = 0;
    while (i < str1.length() && j < str2.length()) {
      if (str1.charAt(i) != str2.charAt(j)) {
        if (edited) {
          return false;
        }
        edited = true;
        if (str1.length() < str2.length()) {
          j++;
        } else if (str1.length() > str2.length()) {
          i++;
        } else {
          i++;
          j++;
        }
      } else {
        i++;
        j++;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    String str1 = "pale";
    String str2 = "ple";
    String str3 = "pales";
    String str4 = "bale";
    String str5 = "bake";

    System.out.println(isOneEdit_3pass(str1, str2));
    System.out.println(isOneEdit_3pass(str1, str3));
    System.out.println(isOneEdit_3pass(str1, str4));
    System.out.println(isOneEdit_3pass(str1, str5));
    System.out.println();
    System.out.println(isOneEdit_1pass(str1, str2));
    System.out.println(isOneEdit_1pass(str1, str3));
    System.out.println(isOneEdit_1pass(str1, str4));
    System.out.println(isOneEdit_1pass(str1, str5));
  }
}
