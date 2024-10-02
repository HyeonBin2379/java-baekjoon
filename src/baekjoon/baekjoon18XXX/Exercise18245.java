package baekjoon.baekjoon18XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exercise18245 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = 1;
        while (true) {
            String input = br.readLine();
            if (input.equals("Was it a cat I saw?")) {
                break;
            }
            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < input.length(); i += (count+1)) {
                answer.append(input.charAt(i));
            }
            bw.write(answer + "\n");
            count++;
        }
        br.close();
        bw.close();
    }
}
