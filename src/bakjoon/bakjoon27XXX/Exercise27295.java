package bakjoon.bakjoon27XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise27295 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long sumX = 0, sumY = 0;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            sumX += Long.parseLong(st.nextToken());
            sumY -= Long.parseLong(st.nextToken());
        }
        sumY += n*b;

        int sign = -1;
        if (sumX < 0) {
            sign *= -1;
            sumX *= -1;
        }
        if (sumY < 0) {
            sign *= -1;
            sumY *= -1;
        }

        if (sumX == 0) {
            System.out.println("EZPZ");
        } else if (sumY % sumX == 0) {
            System.out.println(sumY/sumX * sign);
        } else {
            long gcd = getGCD(Math.abs(sumY), sumX);
            System.out.printf("%d/%d\n", sign*sumY/gcd, sumX/gcd);
        }
    }

    private static long getGCD(long a, long b) {
        while (b > 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
