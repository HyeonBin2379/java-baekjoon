package algorithm.backtracking;

import java.util.Scanner;

public class Exercise15651 {

    private static int n, m;
    private static int[] selected;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        selected = new int[m];
        backtracking(0);
        System.out.println(sb);
    }

    private static void backtracking(int count) {
        if (count == m) {
            for (int i = 0; i < m; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            selected[count] = i;
            backtracking(count+1);
        }
    }
}
