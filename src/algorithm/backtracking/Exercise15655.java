package algorithm.backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise15655 {

    private static final StringBuilder sb = new StringBuilder();

    private static int n, m;
    private static int[] input, selected;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        Arrays.sort(input);

        selected = new int[m];
        visited = new boolean[n];
        backtracking(0, 0);
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
        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[count] = input[i];
                backtracking(count+1, i);
                visited[i] = false;
            }
        }
    }
}
