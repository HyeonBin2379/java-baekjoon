package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1011 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int dist = dest-now;
            int max = (int)Math.sqrt(dist);

            if (max == Math.sqrt(dist)) {
                System.out.println(2*max - 1);
            } else if (dist <= max*max + max) {
                System.out.println(2*max);
            } else {
                System.out.println(2*max+1);
            }
        }
    }
}
