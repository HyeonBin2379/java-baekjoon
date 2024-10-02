package baekjoon.baekjoon04XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exercise4388 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder(st.nextToken());
            String N = sb.reverse().toString();
            int nSize = N.length();

            sb = new StringBuilder(st.nextToken());
            String M = sb.reverse().toString();
            int mSize = M.length();

            if (N.equals("0") && M.equals("0")) {
                break;
            }

            int count = 0, carry = 0;
            for (int i = 0; i < Math.max(nSize, mSize); i++) {
                int n, m = 0;
                if (i < Math.min(nSize, mSize)) {
                    n = N.charAt(i) - '0';
                    m = M.charAt(i) - '0';
                } else {
                    n = (nSize > mSize) ? N.charAt(i) - '0' : M.charAt(i) - '0';
                }

                if (n+m+carry >= 10) {
                    carry = 1;
                    count++;
                } else {
                    carry = 0;
                }
            }
            bw.write(count + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
