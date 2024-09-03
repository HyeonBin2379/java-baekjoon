package bakjoon.bakjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise16756 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n-1; i++) {
            int diff = Math.abs(num[i+1]-num[i]);
            answer = Math.min(diff, answer);
        }
        System.out.println(answer);
    }
}
