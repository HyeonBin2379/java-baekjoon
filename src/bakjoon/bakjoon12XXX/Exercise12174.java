package bakjoon.bakjoon12XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exercise12174 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine());
        for (int i = 1; i <= testcase; i++) {
            int strlen = Integer.parseInt(br.readLine());
            String input = br.readLine().replaceAll("O", "0").replaceAll("I", "1");
            StringBuilder answer = new StringBuilder();
            for (int j = 0; j < input.length(); j += 8) {
                char ch = (char) Integer.parseInt(input.substring(j, j+8), 2);
                answer.append(ch);
            }
            bw.write(String.format("Case #%d: %s\n", i, answer));
        }
        br.close();
        bw.close();
    }
}
