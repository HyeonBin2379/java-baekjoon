package baekjoon.baekjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise11815 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] answer = new int[testCase];
        for (int i = 0; i < testCase; i++) {
            long num = Long.parseLong(st.nextToken());
            long sqrt = (long) Math.sqrt(num);

            if (num == sqrt*sqrt) {
                answer[i] = 1;
            }
        }
        Arrays.stream(answer).forEach(value -> System.out.print(value + " "));
    }
}
