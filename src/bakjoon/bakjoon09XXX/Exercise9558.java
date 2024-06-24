package bakjoon.bakjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise9558 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] num1 = new int[n];
            for (int j = 0; j < n; j++) {
                num1[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                int num2 = Integer.parseInt(st.nextToken());
                for (int k = 0; k < num1.length; k++) {
                    min = Math.min(Math.abs(num2-num1[j]), min);
                }
            }

            System.out.println(min);
        }
    }
}
