package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise23037 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] digit = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < 5; i++) {
            digit[i] = (int)Math.pow(digit[i], 5);
        }
        System.out.println(Arrays.stream(digit).sum());
    }
}
