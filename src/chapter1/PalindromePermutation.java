package chapter1;

public class PalindromePermutation {

  // Time: O(N) Space: O(1)
  public static boolean isPermuPalindrome_ascii(String str) {
    int odd = 0;
    int[] chars = new int[128];
    for (int c : str.toLowerCase().toCharArray()) {
      if (c != ' ') {
        if (++chars[c] % 2 == 1) {
          odd++;
        } else {
          odd--;
        }
      }
    }

    return odd <= 1;
  }

  // Time: O(N) Space: O(1)
  public static boolean isPermuPalindrome_bit(String str) {
    int bit = 0;
    for (int c : str.toLowerCase().toCharArray()) {
      if (c == ' ') {
        continue;
      }

      int mark = 1 << (c - 'a');
      if ((bit & mark) != 0) {
        // next c appears, as mark & mark != 0, then make use mark & ~mark to remove mark;
        bit &= ~mark;
      } else {
        bit |= mark;
      }
    }
    return (bit & (bit -1)) == 0;
  }

  public static void main(String[] args) {
    String input = "Tact Coa";
    System.out.println(isPermuPalindrome_ascii(input));
    System.out.println(isPermuPalindrome_bit(input));
  }
}
