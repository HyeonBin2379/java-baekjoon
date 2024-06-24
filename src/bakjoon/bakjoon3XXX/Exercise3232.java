package bakjoon.bakjoon3XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise3232 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            String[] num = br.readLine().split(" ");

            int answer = 0;
            for (int j = 2; j <= 16; j++) {
                if (checkNum(num[0], j) || checkNum(num[1], j)) {
                    continue;
                }
                int result = Integer.parseInt(num[0], j) * Integer.parseInt(num[1], j);
                if (Integer.toString(result, j).equals(num[2])) {
                    answer = j;
                    break;
                }
            }
            System.out.println(answer);
        }
    }

    private static boolean checkNum(String token, int base) {
        int[] num = Arrays.stream(token.split("")).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(num).anyMatch(value -> value >= base);
    }
}
