package baekjoon.baekjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Exercise9296 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testcase; i++) {
            int n = Integer.parseInt(br.readLine());
            String answer = br.readLine();
            String input = br.readLine();
            long count = IntStream.range(0, n).filter(idx -> answer.charAt(idx) != input.charAt(idx)).count();
            sb.append(String.format("Case %d: %d\n", i, count));
        }
        System.out.print(sb);
    }
}
