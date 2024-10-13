package baekjoon.baekjoon19XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Exercise19699 {

    private static final Set<Integer> answer = new TreeSet<>();
    private static int n, m;
    private static int[] cowWeights;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cowWeights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        visited = new boolean[n];
        search(0, 0);
        if (answer.isEmpty()) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer.stream()
                .map(value -> Integer.toString(value))
                .collect(Collectors.joining(" ")));
    }

    private static boolean isPrimeNum(int num) {
        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void search(int depth, int total) {
        if (depth == m) {
            if (isPrimeNum(total)) {
                answer.add(total);
            }
            return;
        }
        for (int i = depth; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                search(depth+1, total + cowWeights[i]);
                visited[i] = false;
            }
        }
    }
}
