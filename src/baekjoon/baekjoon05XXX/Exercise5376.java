package baekjoon.baekjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise5376 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {
            String input = br.readLine().replaceFirst("0.", "");
            long a, b;
            if (input.contains("(")) {
                int len = input.length()-2;
                int notCycle = input.indexOf("(");
                a = (long)Math.pow(10, len) - (long)Math.pow(10, notCycle);
                b = Long.parseLong(String.join("", input.split("[()]")))
                        - Long.parseLong(notCycle == 0 ? "0" : input.substring(0, notCycle));
            } else {
                int len = input.length();
                a = (long)Math.pow(10, len);
                b = Integer.parseInt(input);
            }
            long gcd = getGCD(a, b);
            System.out.printf("%d/%d\n", b/gcd, a/gcd);
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
