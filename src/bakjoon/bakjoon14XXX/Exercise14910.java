package bakjoon.bakjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise14910 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String answer = "Good";
        for (int i = 1; i < num.length; i++) {
            if (num[i-1] > num[i]) {
                answer = "Bad";
                break;
            }
        }
        System.out.println(answer);
    }
}
