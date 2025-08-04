package algorithm.backtracking;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Exercise5568 {

    private static final Set<Integer> set = new HashSet<>();

    private static int n, k, answer;
    private static int[] arr, selected;
    private static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        selected = new int[k];
        visited = new boolean[n];
        backtracking(0);
        System.out.println(set.size());
    }

    private static void backtracking(int count) {
        if (count == k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k; i++) {
                sb.append(selected[i]);
            }
            set.add(Integer.parseInt(sb.toString()));
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
