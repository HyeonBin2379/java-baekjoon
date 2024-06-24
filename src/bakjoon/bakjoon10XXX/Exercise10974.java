package bakjoon.bakjoon10XXX;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise10974 {

    private static int[] selected;
    private static boolean[] visited;
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        selected = new int[n];
        visited = new boolean[n];
        backTracking(0);
    }

    private static void backTracking(int level) {
        if (level == selected.length) {
            Arrays.stream(selected).forEach(value -> System.out.print(value + " "));
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                selected[level] = i+1;
                visited[i] = true;
                backTracking(level+1);
                visited[i] = false;
            }
        }
    }
}
