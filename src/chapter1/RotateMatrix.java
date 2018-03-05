package chapter1;

import java.util.Arrays;

/**
 * Given an image represented by N*N metrix, where each pixel inthe image is 4 bytes, rotate the image by 90 degrees.
 * Try in place.
 */
public class RotateMatrix {
  //Time: O(n^2) Space: O(1)
  public static void rotate(int[][] image) {
    int n = image.length;
    for (int i = 0; i < n / 2; i++) {
      for (int j = i; j < n - i - 1; j++) {
        int replace = image[i][j];
        image[i][j] = image[n-j-1][i];
        image[n-j-1][i] = image[n-i-1][n-j-1];
        image[n-i-1][n-j-1] = image[j][n-i-1];
        image[j][n-i-1] = replace;
      }
    }
  }

  public static void main(String[] args) {
    int[][] image = {
        {1, 2, 3, 4, 5},
        {6, 7, 8, 9, 10},
        {11, 12, 13, 14, 15},
        {16, 17, 18, 19, 20},
        {21, 22, 23, 24, 25}};
    rotate(image);
    printImage(image);
  }

  private static void printImage(int[][] image) {
    for (int i = 0; i < image.length; i++) {
      System.out.println(Arrays.toString(image[i]));
    }
  }
}
