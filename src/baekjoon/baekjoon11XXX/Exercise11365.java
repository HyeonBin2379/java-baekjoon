package baekjoon.baekjoon11XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exercise11365 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=  new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String input = br.readLine();
            if (input.equals("END")) {
                break;
            }
            StringBuilder sb = new StringBuilder(input);
            bw.write(sb.reverse() + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
