package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise4084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals("0 0 0 0")) {
                break;
            }

            long[] num = Arrays.stream(input.split(" ")).mapToLong(Long::parseLong).toArray();
            long max = Arrays.stream(num).max().getAsLong();
            for (long i = 0; i <= 3*max; i++) {
                if (isSame(num, num[0])) {
                    sb.append(i).append("\n");
                    break;
                }

                long[] temp = new long[4];
                for (int j = 0; j < 4; j++) {
                    temp[j] = Math.abs(num[(j+1) % 4] - num[j % 4]);
                }
                num = Arrays.copyOf(temp, 4);
            }
        }
        System.out.print(sb);
    }

    public static boolean isSame(long[] num, long val) {
        return Arrays.stream(num).allMatch(value -> value == val);
    }
}
