package baekjoon.baekjoon05XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Exercise5717 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String input = br.readLine();
            if (input.equals("0 0")) {
                break;
            }
            int sum = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).sum();
            bw.write(sum + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
