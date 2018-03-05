package chapter1;

/**
 * Check if string s2 is a rotation of string s1 wiht one call to
 * isSubstring which checks if one word is a substring of another.
 */
public class StringRotation {

  //Time: O(1) Space: O(N)
  public static boolean isRotation(String s1, String s2) {
    if (s1 == null || s2 == null || s1.length() != s2.length()) {
      return false;
    }

    String str = s2 + s2;
    return isSubstring(str, s1);
  }

  private static boolean isSubstring(String str, String sub) {
    return true;
  }
}
