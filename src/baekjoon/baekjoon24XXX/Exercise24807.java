package baekjoon.baekjoon24XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exercise24807 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int legs = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i = 0; i <= legs/b; i++) {
            for (int j = 0; j <= legs/d; j++) {
                for (int k = 0; k <= legs/c; k++) {
                    if (b*i + d*j + c*k == legs) {
                        bw.write(i + " " + j + " " + k + "\n");
                        count++;
                    }
                }
            }
        }
        if (count == 0) {
            bw.write("impossible");
        }
        bw.flush();
        bw.close();
    }
}
