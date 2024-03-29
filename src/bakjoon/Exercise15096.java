package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise15096 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] advance = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sum = Arrays.stream(advance).filter(value -> value >= 1).sum();
        int walk = (int) Arrays.stream(advance).filter(value -> value == -1).count();
        System.out.printf("%.3f\n", (double)sum/(n-walk));
    }
}
