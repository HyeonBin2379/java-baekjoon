package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise16861 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(br.readLine());
        while (true) {
            int[] digit = Arrays.stream(Long.toString(num).split("")).mapToInt(Integer::parseInt).toArray();
            int sum = Arrays.stream(digit).sum();
            if (num % sum == 0) {
                break;
            }
            num++;
        }
        System.out.println(num);
    }
}
