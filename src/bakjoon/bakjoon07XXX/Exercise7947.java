package bakjoon.bakjoon07XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise7947 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int[] result = new int[3];
            for (int j = 0; j < 10; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 3; k++) {
                    result[k] += Integer.parseInt(st.nextToken());
                }
            }
            Arrays.stream(result)
                    .map(operand -> (int)Math.round(operand/10.0))
                    .forEach(value -> sb.append(value).append(" "));
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
