package bakjoon.bakjoon3XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise3040 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            num[i] = Integer.parseInt(br.readLine());
            sum += num[i];
        }

        int idx1 = 0, idx2 = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 9; j++) {
                if (sum - num[i] - num[j] == 100) {
                    idx1 = i;
                    idx2 = j;
                    break;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            if (num[i] == num[idx1] || num[i] == num[idx2]) {
                continue;
            }
            System.out.println(num[i]);
        }
    }
}
