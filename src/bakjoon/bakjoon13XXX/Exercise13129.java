package bakjoon.bakjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise13129 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] height = new int[n];
        for (int i = 1; i <= n; i++) {
            height[i-1] = a*n + b*(n+1-i);
        }
        Arrays.sort(height);
        Arrays.stream(height).forEach(value -> System.out.print(value + " "));
    }
}
