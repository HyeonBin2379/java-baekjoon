package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Exercise15666 {

    private static final Set<String> answer = new LinkedHashSet<>();

    private static int n, m;
    private static int[] input, selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        selected = new int[m];
        backtracking(0, 0);
        answer.forEach(System.out::println);
    }

    private static void backtracking(int count, int start) {
        if (count == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(selected[i]).append(" ");
            }
            answer.add(sb.toString().trim());
            return;
        }
        for (int i = start; i < n; i++) {
            selected[count] = input[i];
            backtracking(count+1, i);
        }
    }
}
