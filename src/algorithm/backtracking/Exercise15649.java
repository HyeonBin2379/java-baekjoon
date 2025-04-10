package algorithm.backtracking;

import java.util.Scanner;

public class Exercise15649 {

    private static int n, m;
    private static int[] selected;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        selected = new int[m];
        visited = new boolean[n+1];
        backtracking(0);
    }

    private static void backtracking(int count) {
        if (count == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(selected[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[count] = i;
                backtracking(count+1);
                selected[count] = 0;
                visited[i] = false;
            }
        }
    }
}
