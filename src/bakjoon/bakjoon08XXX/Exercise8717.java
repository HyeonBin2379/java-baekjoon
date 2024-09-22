package bakjoon.bakjoon08XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise8717 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int answer = Integer.MAX_VALUE;
        int totalSum = Arrays.stream(num).sum();
        int leftSum = 0;
        for (int i = 0; i < n-1; i++) {
            leftSum += num[i];
            answer = Math.min(Math.abs(2*leftSum-totalSum), answer);
        }
        System.out.println(answer);
    }
}
