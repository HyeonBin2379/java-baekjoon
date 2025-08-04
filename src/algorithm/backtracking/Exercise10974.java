package algorithm.backtracking;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Exercise10974 {

    private static final StringBuilder sb = new StringBuilder();

    private static int n;
    private static int[] arr, selected;
    private static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = IntStream.rangeClosed(1, n).toArray();

        selected = new int[n];
        visited = new boolean[n];
        backtracking(0);
        System.out.print(sb);
    }

    private static void backtracking(int count) {
        if (count == n) {
            for (int i = 0; i < n; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                selected[count] = arr[i];
                visited[i] = true;
                backtracking(count+1);
                visited[i] = false;
            }
        }
    }
}
