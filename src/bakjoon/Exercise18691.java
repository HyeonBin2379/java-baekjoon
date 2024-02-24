package bakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exercise18691 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if (c > e) {
                bw.write(0 + "\n");
                continue;
            }
            switch (g) {
                case 1 -> bw.write((e - c) + "\n");
                case 2 -> bw.write((e - c)*3 + "\n");
                case 3 -> bw.write((e - c)*5 + "\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
