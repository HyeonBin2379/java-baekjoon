package algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise1439 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] bits = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        int answer = 1;
        for (int i = 1; i < bits.length; i++) {
            if (bits[i-1] != bits[i]) {
                answer++;
            }
        }
        System.out.println(answer / 2);
    }
}
