package baekjoon.baekjoon24XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Exercise24510 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            int count = (int) IntStream.rangeClosed(0, line.length()-1)
                    .filter(idx -> line.startsWith("for", idx) || line.startsWith("while", idx))
                    .count();
            answer = Math.max(count, answer);
        }
        System.out.println(answer);
    }
}
