package baekjoon.baekjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise9255 {

    private static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testcase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            IntStream.range(0, n).forEach(idx -> graph.add(new ArrayList<>()));
            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken())-1;
                int to = Integer.parseInt(st.nextToken())-1;
                graph.get(from).add(to);
                graph.get(to).add(from);
            }
            int s = Integer.parseInt(br.readLine())-1;
            sb.append(String.format("Data Set %d:\n", i));
            sb.append(graph.get(s).stream()
                            .sorted()
                            .distinct()
                            .map(num -> Integer.toString(num+1))
                            .collect(Collectors.joining(" ")))
                    .append("\n\n");
        }
        System.out.print(sb);
    }
}