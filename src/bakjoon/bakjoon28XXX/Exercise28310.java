package bakjoon.bakjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise28310 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            BigInteger[][] cookies = new BigInteger[m][n+1];
            BigInteger de = BigInteger.ONE;     // 분모, long 범위를 초과할 수도 있음
            for (int j = 0; j < m; j++) {
                cookies[j] = Arrays.stream(br.readLine().split(" "))
                        .map(BigInteger::new)
                        .toArray(BigInteger[]::new);

                // 통분 없이 모든 분모의 곱으로 계산하여 이후의 계산 과정 간략화
                de = de.multiply(cookies[j][0]);
            }

            // 각 고양이별 분자값 계산
            BigInteger[] cat = new BigInteger[n];
            Arrays.fill(cat, BigInteger.ZERO);
            for (int j = 1; j <= n; j++) {
                for (int k = 0; k < m; k++) {
                    cat[j-1] = cat[j-1].add(de.divide(cookies[k][0]).multiply(cookies[k][j]));
                }
            }
            Arrays.sort(cat);
            BigInteger diff = cat[n-1].subtract(cat[0]);

            // 분자가 분모로 나눠떨어지면 정수, 그렇지 않으면 기약분수
            if (diff.remainder(de).longValue() == 0) {
                System.out.println(diff.divide(de));
            } else {
                BigInteger gcd = diff.gcd(de);
                System.out.printf("%d/%d\n", diff.divide(gcd), de.divide(gcd));
            }
        }
    }
}
