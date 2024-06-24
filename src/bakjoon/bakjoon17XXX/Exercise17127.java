package bakjoon.bakjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise17127 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            int mul = 1;
            int sum = Arrays.stream(num).sum();
            for (int j = i; j < i+n-3; j++) {
                mul *= num[j];
                sum -= num[j];
            }
            answer = Math.max(sum+mul, answer);
        }
        System.out.println(answer);
    }
}
