package bakjoon.bakjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise10698 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            String[] token = Arrays.stream(br.readLine().split(" ")).filter(s -> !s.equals("=")).toArray(String[]::new);
            int x = Integer.parseInt(token[0]);
            int y = Integer.parseInt(token[2]);
            int sum = Integer.parseInt(token[3]);
            sb.append(String.format("Case %d: ", i));
            switch (token[1]) {
                case "+" -> sb.append((x + y == sum) ? "YES" : "NO").append("\n");
                case "-" -> sb.append((x - y == sum) ? "YES" : "NO").append("\n");
            }
        }
        System.out.print(sb);
    }
}
