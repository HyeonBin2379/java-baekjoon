package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Exercise2684 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            String toss = Arrays.stream(br.readLine().split(""))
                    .map(s -> s.equals("H") ? "1" : "0")
                    .collect(Collectors.joining());
            int[] tossCase = new int[8];
            for (int j = 0; j < toss.length()-2; j++) {
                tossCase[Integer.parseInt(toss.substring(j, j+3), 2)]++;
            }
            Arrays.stream(tossCase).forEach(value -> sb.append(value).append(" "));
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
