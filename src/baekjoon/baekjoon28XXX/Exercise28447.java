package baekjoon.baekjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise28447 {

    private static int n, k;
    private static Integer[] selected;
    private static boolean[] visited;
    private static final List<Integer[]> combination = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[][] taste = new int[n][n];
        for (int i = 0; i < n; i++) {
            taste[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        selected = IntStream.range(0, k).map(idx -> -1).boxed().toArray(Integer[]::new);
        visited = new boolean[n];
        Arrays.fill(selected, 0);
        getCombinations(0, 0);

        int result = -(int) 1e9;
        for (Integer[] selected : combination) {
            int temp = 0;
            for (int i = 0; i < k-1; i++) {
                for (int j = i+1; j < k; j++) {
                    temp += taste[selected[i]][selected[j]];
                }
            }
            result = Math.max(temp, result);
        }
        System.out.println(result);
    }

    private static void getCombinations(int count, int start) {
        if (count == k) {
            combination.add(selected.clone());
            return;
        }
        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[count] = i;
                getCombinations(count + 1, i + 1);
                selected[count] = 0;
                visited[i] = false;
            }
        }
    }
}
