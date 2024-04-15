package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise22361 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals("0 0")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] col = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int[] digit = new int[10];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int mul = row[i]*col[j];
                    while (mul > 0) {
                        digit[mul % 10]++;
                        mul /= 10;
                    }
                }
            }

            for (int cnt : digit) {
                sb.append(cnt).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
