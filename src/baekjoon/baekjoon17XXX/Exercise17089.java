package baekjoon.baekjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise17089 {

    private static final List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        IntStream.rangeClosed(0, n).forEach(idx -> graph.add(new ArrayList<>()));
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int answer = Integer.MAX_VALUE;
        for (int a = 1; a <= n; a++) {
            for (int b = a+1; b <= n; b++) {
                if (!graph.get(a).contains(b)) {
                    continue;
                }
                for (int c = b+1; c <= n; c++) {
                    if (!graph.get(c).contains(a) || !graph.get(c).contains(b)) {
                        continue;
                    }
                    int sum = graph.get(a).size() + graph.get(b).size() + graph.get(c).size() - 6;
                    answer = Math.min(sum, answer);
                }
            }
        }
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}
