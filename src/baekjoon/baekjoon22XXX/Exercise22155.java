package baekjoon.baekjoon22XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exercise22155 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int branch = Integer.parseInt(st.nextToken());
            int loop = Integer.parseInt(st.nextToken());
            if ((branch <= 1 && loop <= 2) || (branch <= 2 && loop <= 1)) {
                bw.write("Yes\n");
            } else {
                bw.write("No\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
