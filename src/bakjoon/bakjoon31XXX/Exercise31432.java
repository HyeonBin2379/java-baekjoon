package bakjoon.bakjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise31432 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if (n == 1) {
            if (num[0] == 0) {
                System.out.println("YES\n0");
                return;
            }
        }
        System.out.println("YES\n" + Integer.toString(num[n-1]).repeat(3));
    }
}
