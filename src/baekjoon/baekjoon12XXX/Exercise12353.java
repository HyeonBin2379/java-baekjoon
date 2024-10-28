package baekjoon.baekjoon12XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise12353 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String gender = st.nextToken();
            int[] mother = Arrays.stream(st.nextToken().split("['\"]"))
                    .filter(s -> !s.isEmpty())
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] father = Arrays.stream(st.nextToken().split("['\"]"))
                    .filter(s -> !s.isEmpty())
                    .mapToInt(Integer::parseInt)
                    .toArray();
            double total = mother[0]*12+mother[1] + father[0]*12+father[1];
            switch (gender) {
                case "B" -> total += 5;
                case "G" -> total -= 5;
            }
            int lower = (int) Math.ceil(total/2.0-4);
            int upper = (int) (total/2.0+4);
            sb.append(String.format("Case #%d: %d'%d\" to %d'%d\"\n", i, lower/12, lower%12, upper/12, upper%12));
        }
        System.out.print(sb);
    }
}
