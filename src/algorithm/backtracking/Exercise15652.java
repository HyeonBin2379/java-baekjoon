package algorithm.backtracking;

import java.util.Scanner;

public class Exercise15652 {

    private static final StringBuilder sb = new StringBuilder();

    private static int n, m;
    private static int[] selected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        selected = new int[n];
        backtracking(0, 1);
        System.out.println(sb);
    }

    private static void backtracking(int count, int start) {
        if (count == m) {
            for (int i = 0; i < m; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i <= n; i++) {
            selected[count] = i;
            backtracking(count+1, i);
            selected[count] = 0;
        }
    }
}
