package algorithm.backtracking;

import java.util.Scanner;

public class Exercise15650 {

    private static int n, m;
    private static int[] selected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        selected = new int[m+1];
        backtracking(0, 1);
    }

    private static void backtracking(int count, int start) {
        if (count == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(selected[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i <= n; i++) {
            if (selected[count] == 0) {
                selected[count] = i;
                backtracking(count + 1, i+1);
                selected[count] = 0;
            }
        }
    }
}
