package bakjoon.bakjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise25814 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num1 = Arrays.stream(st.nextToken().split("")).mapToInt(Integer::parseInt).toArray();
        int[] num2 = Arrays.stream(st.nextToken().split("")).mapToInt(Integer::parseInt).toArray();

        int result1 = num1.length * Arrays.stream(num1).sum();
        int result2 = num2.length * Arrays.stream(num2).sum();
        if (result1 > result2) {
            System.out.println(1);
        } else if (result1 < result2) {
            System.out.println(2);
        } else {
            System.out.println(0);
        }
    }
}
