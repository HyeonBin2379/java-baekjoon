package bakjoon.bakjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise31617 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] num1 = Arrays.stream(br.readLine().split(" ", n)).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(br.readLine());
        int[] num2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (num1[i] + k == num2[j]) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
