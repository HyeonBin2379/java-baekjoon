package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise8794 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            if (l != 1) {
                n -= (m - l + 1);
            }
            int answer = (n % m == 0) ? n/m : n/m+1;
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
