package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise21146 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += Integer.parseInt(br.readLine());
        }
        int min = sum + (n-k)*(-3);
        int max = sum + (n-k)*3;
        System.out.printf("%.4f %.4f\n", (double)min/n, (double)max/n);
    }
}
