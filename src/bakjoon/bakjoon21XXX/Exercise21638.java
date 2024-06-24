package bakjoon.bakjoon21XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise21638 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] today = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] tomorrow = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if (tomorrow[0] < 0 && tomorrow[1] >= 10) {
            System.out.println("A storm warning for tomorrow! Be careful and stay home if possible!");
        } else if (tomorrow[0] < today[0]) {
            System.out.println("MCHS warns! Low temperature is expected tomorrow.");
        } else if (tomorrow[1] > today[1]) {
            System.out.println("MCHS warns! Strong wind is expected tomorrow.");
        } else {
            System.out.println("No message");
        }
    }
}
