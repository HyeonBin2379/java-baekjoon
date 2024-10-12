package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Exercise2668 {

    private static List<Integer> list;
    private static int[] numbers;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        numbers = new int[n+1];
        for (int i = 1; i <= n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        list = new ArrayList<>();
        visited = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }
        System.out.println(list.size());
        list.stream().sorted().forEach(System.out::println);
    }

    private static void dfs(int start, int target) {
        if (numbers[start] == target) {
            list.add(target);
            return;
        }
        if (!visited[numbers[start]]) {
            visited[numbers[start]] = true;
            dfs(numbers[start], target);
            visited[numbers[start]] = false;
        }
    }
}
