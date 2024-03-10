package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise27106 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cost = 100 - Integer.parseInt(br.readLine());
        int[] cent = {25, 10, 5, 1};
        int[] count = new int[4];

        for (int i = 0; i < 4; i++) {
            count[i] = cost/cent[i];
            cost %= cent[i];
        }
        Arrays.stream(count).forEach(value -> System.out.print(value + " "));
    }
}
