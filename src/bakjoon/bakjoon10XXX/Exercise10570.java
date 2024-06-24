package bakjoon.bakjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise10570 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int[] numbers = new int[1001];
            int n = Integer.parseInt(br.readLine());
            int max = 0;
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(br.readLine());
                numbers[num]++;
                max = Math.max(numbers[num], max);
            }

            for (int j = 0; j <= 1000; j++) {
                if (numbers[j] == max) {
                    System.out.println(j);
                    break;
                }
            }
        }
    }
}
