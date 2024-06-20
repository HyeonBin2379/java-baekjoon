package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise14726 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int[] num = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            System.out.println(getSum(num) % 10 == 0 ? "T" : "F");
        }
    }

    private static int getSum(int[] num) {
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            int newNum = (i % 2 == 1) ? num[num.length-1-i]*2 : num[num.length-1-i];
            if (newNum >= 10) {
                while (newNum > 0) {
                    sum += newNum % 10;
                    newNum /= 10;
                }
            } else {
                sum += newNum;
            }
        }
        return sum;
    }
}
