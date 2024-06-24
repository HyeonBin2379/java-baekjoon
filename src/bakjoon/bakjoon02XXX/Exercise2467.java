package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise2467 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] sol = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).sorted().toArray();

        long[] answer = {sol[0], sol[1]};
        long min = Long.MAX_VALUE;
        int left = 0, right = n-1;

        while (left < right) {
            long value = sol[left] + sol[right];
            if (Math.abs(value) < min) {
                min = Math.abs(value);
                answer = new long[] {sol[left], sol[right]};
            }

            if (value < 0) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}
