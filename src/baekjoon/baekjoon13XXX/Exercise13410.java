package baekjoon.baekjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise13410 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] num = new int[k];
        for (int i = 1; i <= k; i++) {
            StringBuilder value = new StringBuilder(Integer.toString(n*i));
            num[i-1] = Integer.parseInt(value.reverse().toString());
        }
        System.out.println(Arrays.stream(num).max().getAsInt());
    }
}
