package bakjoon.bakjoon27XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise27110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int chicken = Integer.parseInt(br.readLine());
        int[] order = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();
        System.out.println(Arrays.stream(order)
                .map(operand -> Math.min(operand, chicken))
                .sum());
    }
}
