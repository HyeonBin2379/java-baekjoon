package baekjoon.baekjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise9913 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[10001];
        while (n-- > 0) {
            int value = Integer.parseInt(br.readLine());
            num[value]++;
        }
        System.out.println(Arrays.stream(num).reduce(0, Integer::max));
    }
}
