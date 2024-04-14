package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise2495 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            int[] num = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            int[] digit = new int[10];
            int seq = 1;

            Arrays.fill(digit, 1);
            for (int j = 1; j < 8; j++) {
                if (num[j-1] == num[j]) {
                    seq++;
                } else {
                    digit[num[j-1]] = Math.max(seq, digit[num[j-1]]);
                    seq = 1;
                }
            }
            digit[num[7]] = Math.max(seq, digit[num[7]]);
            System.out.println(Arrays.stream(digit).max().getAsInt());
        }
    }
}
