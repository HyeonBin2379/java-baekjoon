package bakjoon.bakjoon27XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise27267 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = num[0] * num[1];
        int n = num[2] * num[3];
        if (m > n) {
            System.out.println("M");
        } else if (m == n) {
            System.out.println("E");
        } else {
            System.out.println("P");
        }
    }
}
