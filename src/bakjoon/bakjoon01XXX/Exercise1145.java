package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise1145 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(num);

        int answer = num[0];
        while (true) {
            int count = 0;
            for (int j : num) {
                count += (answer % j == 0) ? 1 : 0;
            }
            if (count >= 3) {
                break;
            }
            answer++;
        }
        System.out.println(answer);
    }
}
