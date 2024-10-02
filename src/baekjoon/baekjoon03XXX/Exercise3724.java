package baekjoon.baekjoon03XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise3724 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            BigInteger[] num = new BigInteger[m];
            Arrays.fill(num, BigInteger.ONE);
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    num[k] = num[k].multiply(new BigInteger(st.nextToken()));
                }
            }

            BigInteger max = num[0];
            int answer = 1;
            for (int j = 1; j < m; j++) {
                if (max.compareTo(num[j]) <= 0) {
                    max = num[j];
                    answer = j+1;
                }
            }
            System.out.println(answer);
        }
    }
}
