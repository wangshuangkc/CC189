package chapter1;

/**
 * Perform string compression suing the counts of repeated characters, e.g. aabcccccaaa -> a2b1c5a3.
 * If the compressed string would not become smaller than the original, return the original. Only letters.
 */
public class StringCompression {
  // Time: O(N) Space: O(N)
  public static String compress(String str) {
    if (str == null || str.isEmpty() || str.length() < 3) {
      return str;
    }
    int strLen = str.length();
    StringBuffer sb = new StringBuffer(strLen);
    int cnt = 0;
    for (int i = 0; i < strLen; i++) {
      cnt++;

      if (i + 1 >= strLen || str.charAt(i) != str.charAt(i + 1)) {
        sb.append(str.charAt(i));
        sb.append(cnt);
        cnt = 0;
      }

      if (sb.length() >= strLen) {
        return str;
      }
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    String str1 = "aabcccccaaa";
    String str2 = "abcdddd";
    System.out.println(compress(str1));
    System.out.println(compress(str2));
  }
}
