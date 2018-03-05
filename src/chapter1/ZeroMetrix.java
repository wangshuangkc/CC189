package chapter1;

import java.util.Arrays;

/**
 * If an element in an M*N metrix is 0, its entire row and column are set to 0.
 */
public class ZeroMetrix {

  // Time: O(m*n) Space: O(m+n)
  public static void setZero(int[][] metrix) {
    int m = metrix.length;
    int n = metrix[0].length;
    boolean[] rows = new boolean[m];
    boolean[] cols = new boolean[n];

    for (int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if (metrix[i][j] == 0) {
          rows[i] = true;
          cols[j] = true;
        }
      }
    }

    for (int i = 0; i < m; i++) {
      if (rows[i]) {
        setRowToZero(metrix, i);
      }
    }
    for (int j = 0; j < n; j++) {
      if (cols[j]) {
        setColToZero(metrix, j);
      }
    }
  }

  // Time: O(m*n) Space: O(1)
  public static void setZero_inPlace(int[][] metrix) {
    int m = metrix.length;
    int n = metrix[0].length;

    // check the first row and col
    boolean row = false;
    boolean col = false;
    for (int i : metrix[0]) {
      if (i == 0) {
        row = true;
        break;
      }
    }
    for (int i = 0; i < m; i++) {
      if (metrix[i][0] == 0) {
        col = true;
        break;
      }
    }

    // migrate 0 to the first row and col
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (metrix[i][j] == 0) {
          metrix[0][j] = 0;
          metrix[i][0] = 0;
        }
      }
    }

    // set 0
    for (int i = 1; i < m; i++) {
      if (metrix[i][0] == 0) {
        setRowToZero(metrix, i);
      }
    }
    for (int j = 1; j < n; j++) {
      if (metrix[0][j] == 0) {
        setColToZero(metrix, j);
      }
    }

    // set first row and col
    if (row) {
      setRowToZero(metrix, 0);
    }
    if (col) {
      setColToZero(metrix, 0);
    }
  }

  private static void setRowToZero(int[][]metrix, int row) {
    for (int i = 0; i < metrix[0].length; i++) {
      metrix[row][i] = 0;
    }
  }

  private static void setColToZero(int[][] metrix, int col) {
    for (int i = 0; i < metrix.length; i++) {
      metrix[i][col] = 0;
    }
  }

  public static void main(String[] args) {
    int[][] metrix = {
        {0, 2, 3, 4, 5},
        {6, 7, 8, 9, 10},
        {11, 12, 0, 14, 15},
        {16, 17, 18, 19, 0},
        {21, 22, 23, 24, 25}};

    setZero(metrix);
    printMetrix(metrix);
    System.out.println();

    int[][] metrix2 = {
        {0, 2, 3, 4, 5},
        {6, 7, 8, 9, 10},
        {11, 12, 0, 14, 15},
        {16, 17, 18, 19, 0},
        {21, 22, 23, 24, 25}};
    setZero_inPlace(metrix2);
    printMetrix(metrix2);
  }

  private static void printMetrix(int[][] metrix) {
    for (int i = 0; i < metrix.length; i++) {
      System.out.println(Arrays.toString(metrix[i]));
    }
  }
}
