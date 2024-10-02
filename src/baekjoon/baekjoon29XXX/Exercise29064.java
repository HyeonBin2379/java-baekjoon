package baekjoon.baekjoon29XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise29064 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ready = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int state = Integer.parseInt(st.nextToken());
            ready += (state == 1) ? 1 : 0;
        }

        int half = (int) Math.ceil((double)n/2);
        if (ready >= half) {
            System.out.println(0);
        } else {
            System.out.println(half-ready);
        }
    }
}
