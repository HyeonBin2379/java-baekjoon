package baekjoon.baekjoon04XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exercise4740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            StringBuilder sb = new StringBuilder(br.readLine());
            if (sb.toString().equals("***")) {
                break;
            }
            String result = sb.reverse().toString();
            bw.write(result + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
