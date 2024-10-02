package baekjoon.baekjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise26026 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lec = Integer.parseInt(br.readLine());
        int[] machine = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        int wakeup = 0;
        int coffee = 0;
        for (int i = 0; i < lec; i++) {
            if (machine[i] == 0) {
                if (coffee > 0) {
                    coffee--;
                    wakeup++;
                }
            } else {
                wakeup++;
                if (coffee > 0) {
                    coffee--;
                }
                coffee = Math.min(coffee+2, 2);
            }
        }
        System.out.println(wakeup);
    }
}
