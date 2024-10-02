package baekjoon.baekjoon24XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise24312 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] weight = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(weight);

        int sum = Arrays.stream(weight).sum();
        int diff1 = Math.abs((weight[0]+weight[3] - weight[2] - weight[1]));
        int diff2 = Math.abs((sum - weight[3]) - weight[3]);
        System.out.println(Math.min(diff1, diff2));
    }
}
