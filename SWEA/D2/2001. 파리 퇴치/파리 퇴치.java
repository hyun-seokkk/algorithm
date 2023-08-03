import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int tc = 1; tc <= t; tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            int[] killLog = new int[n * n * m * m];
            int index = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int now = 0;
                    for (int m1 = 0; m1 < m; m1++) {
                        for (int m2 = 0; m2 < m; m2++) {
                            if (i + m1 < n && j + m2 < n) {
                                now += matrix[i + m1][j + m2];
                            }
                        }
                    }
                    killLog[index++] = now;
                }
            }

            int maxKill = Integer.MIN_VALUE;
            for (int k : killLog) {
                maxKill = Math.max(maxKill, k);
            }
            System.out.println("#" + tc + " " + maxKill);
        }
    }
}