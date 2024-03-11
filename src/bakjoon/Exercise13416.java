package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise13416 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            int benefit = 0;
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int max = 0;
                for (int k = 0; k < 3; k++) {
                    int value = Integer.parseInt(st.nextToken());
                    max = Math.max(value, max);
                }
                benefit += max;
            }
            System.out.println(benefit);
        }
    }
}
