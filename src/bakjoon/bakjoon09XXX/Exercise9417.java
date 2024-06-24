package bakjoon.bakjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise9417 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int max = 0;
            for (int i = 0; i < num.length-1; i++) {
                for (int j = i+1; j < num.length; j++) {
                    max = Math.max(getGCD(num[i], num[j]), max);
                }
            }
            System.out.println(max);
        }
    }

    private static int getGCD(int a, int b) {
        while (b > 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
