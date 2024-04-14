package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise2145 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals("0")) {
                break;
            }

            if (input.length() == 1) {
                System.out.println(input);
                continue;
            }

            int sum = 0;
            while (input.length() > 1) {
                int[] digit = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
                sum = Arrays.stream(digit).sum();
                input = Integer.toString(sum);
            }
            System.out.println(sum);
        }
    }
}
