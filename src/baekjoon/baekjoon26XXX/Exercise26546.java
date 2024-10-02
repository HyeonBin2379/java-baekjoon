package baekjoon.baekjoon26XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exercise26546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String[] token = br.readLine().split(" ");
            int start = Integer.parseInt(token[1]);
            int end = Integer.parseInt(token[2]);
            token[0] = token[0].replace(token[0].substring(start, end), "");
            bw.write(token[0] + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
