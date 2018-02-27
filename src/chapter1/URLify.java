package chapter1;

/**
 * Write a method to replace all spaces in a stirng with'%20'.
 * Assume that the String has sufficient space at the end to hold the additonal characters, and
 * the true length of the string is given. User char array to implement in place.
 *
 * Common approach for string manipulation is to edit backwards.
 */
public class URLify {
  public static void urlify(char[] str, int len) {
    int end = str.length - 1;
    for (int i = len - 1; i != end; i--) {
      if (str[i] != ' ') {
        str[end--] = str[i];
      } else {
        str[end--] = '0';
        str[end--] = '2';
        str[end--] = '%';
      }
    }
  }

  public static void main(String[] args) {
    String str = "Mr John Smith    ";
    int len = str.trim().length();
    char[] chars = str.toCharArray();

    urlify(chars, len);
    System.out.println(chars);
  }
}
