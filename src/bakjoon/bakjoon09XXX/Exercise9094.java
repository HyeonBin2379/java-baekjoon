package bakjoon.bakjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise9094 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int count = 0;
            for (int a = 1; a < n; a++) {
                for (int b = a+1; b < n; b++) {
                    if ((a*a+b*b+m) % (a*b) == 0) {
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}
