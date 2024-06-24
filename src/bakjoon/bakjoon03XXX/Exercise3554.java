package bakjoon.bakjoon03XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise3554 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(br.readLine());
        while(m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int sum = 0;
            if (k == 1) {
                for (int i = l-1; i < r; i++) {
                    num[i] *= num[i];
                    num[i] %= 2010;
                }
            } else {
                for (int j = l-1; j < r; j++) {
                    sum += num[j];
                }
                sb.append(sum).append("\n");
            }
        }
        System.out.print(sb);
    }
}
