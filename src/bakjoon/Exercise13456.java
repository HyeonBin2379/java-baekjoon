package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise13456 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] num1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] num2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int hamming = 0;
            for (int j = 0; j < n; j++) {
                if (num1[j] != num2[j]) {
                    hamming++;
                }
            }
            System.out.println(hamming);
        }
    }
}
