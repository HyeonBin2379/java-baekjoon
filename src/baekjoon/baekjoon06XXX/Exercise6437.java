package baekjoon.baekjoon06XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise6437 {
    public static Map<Integer, String> golf = new LinkedHashMap<>(Map.of(
            -3, "Double eagle.",
            -2, "Eagle.",
            -1, "Birdie.",
            0, "Par.",
            1, "Bogey."
    ));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            if (p == 0 && s == 0) {
                break;
            }
            sb.append(String.format("Hole #%d\n", ++count));
            if (s == 1) {
                sb.append("Hole-in-one.").append("\n\n");
                continue;
            }
            sb.append((s-p >= 2) ? "Double Bogey." : golf.get(s-p)).append("\n\n");
        }
        System.out.print(sb);
    }
}
