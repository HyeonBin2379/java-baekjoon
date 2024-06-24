package bakjoon.bakjoon29XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise29587 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if (hasSequence(num, n)) {
            System.out.println(0);
        } else {
            System.out.println(n);
            IntStream.rangeClosed(1, n).forEach(value -> System.out.print(value + " "));
        }
    }

    private static boolean hasSequence(int[] num, int len) {
        for (int i = 1; i < len; i++) {
            if (num[i-1] >= num[i]) {
                return false;
            }
        }
        return true;
    }
}
