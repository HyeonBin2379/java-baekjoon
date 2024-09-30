package bakjoon.bakjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise13280 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            int[] num = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n-1; i++) {
                for (int j = i+1; j < n; j++) {
                    min = Math.min(Math.abs(num[i]-num[j]), min);
                }
                if (min == 0) {
                    break;
                }
            }
            System.out.println(min);
        }
    }
}
