package bakjoon.bakjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise11368 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals("0 0 0 0")) {
                break;
            }
            int[] num = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            if (num[0] == 1) {
                System.out.println(1);
                continue;
            }
            long total = (long) Math.pow(num[0], num[1]*num[2]*num[3]);
            System.out.println(total);
        }
    }
}
