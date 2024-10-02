package baekjoon.baekjoon31XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise31052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[] location = Arrays.stream(br.readLine().split(" ", n)).mapToLong(Long::parseLong).toArray();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int queryType = Integer.parseInt(st.nextToken());
            switch (queryType) {
                case 1 -> {
                    int company = Integer.parseInt(st.nextToken()) - 1;
                    long newLocation = Long.parseLong(st.nextToken());
                    location[company] = newLocation;
                }
                case 2 -> {
                    int a = Integer.parseInt(st.nextToken()) - 1;
                    int b = Integer.parseInt(st.nextToken()) - 1;
                    bw.write(Math.abs(location[a] - location[b]) + "\n");
                }
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
