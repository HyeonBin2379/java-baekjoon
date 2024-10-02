package baekjoon.baekjoon18XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exercise18917 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());

        long sum = 0;
        long xor = 0;
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int queryType = Integer.parseInt(st.nextToken());
            long num;
            switch (queryType) {
                case 1 -> {
                    num = Long.parseLong(st.nextToken());
                    sum += num;
                    xor ^= num;
                }
                case 2 -> {
                    num = Long.parseLong(st.nextToken());
                    sum -= num;
                    xor ^= num;
                }
                case 3 -> bw.write(sum + "\n");
                case 4 -> bw.write(xor + "\n");
            }
        }
        br.close();
        bw.close();
    }
}
