package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise31798 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < 3; i++) {
            if (num[i] == 0) {
                int answer = switch (i) {
                    case 0 -> num[2] * num[2] - num[1];
                    case 1 -> num[2] * num[2] - num[0];
                    case 2 -> (int) Math.sqrt(num[1] + num[0]);
                    default -> 0;
                };
                System.out.println(answer);
                return;
            }
        }
    }
}
