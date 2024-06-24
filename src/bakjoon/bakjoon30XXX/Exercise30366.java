package bakjoon.bakjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise30366 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int count = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum + num[i] <= m) {
                sum += num[i];
                sb.append(count).append("\n");
            } else {
                count++;
                sum = num[i];
                sb.append(count).append("\n");
            }
        }
        System.out.print(sb);
    }
}
