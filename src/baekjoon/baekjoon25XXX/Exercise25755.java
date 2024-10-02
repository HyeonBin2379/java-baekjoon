package baekjoon.baekjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise25755 {

    private static final Map<Integer, String> mirror = new HashMap<>(Map.of(
            1, "1", 2, "5", 3, "?", 4, "?",
            5, "2", 6, "?", 7, "?", 8, "8", 9, "?"
    ));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String w = st.nextToken();
        int n = Integer.parseInt(st.nextToken());
        int[][] before = new int[n][n];
        for (int i = 0; i < n; i++) {
            before[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        String[][] after = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                switch (w) {
                    case "L", "R" -> after[i][j] = mirror.get(before[i][n - 1 - j]);
                    case "U", "D" -> after[i][j] = mirror.get(before[n - 1 - i][j]);
                }
            }
            System.out.println(String.join(" ", after[i]));
        }
    }
}
