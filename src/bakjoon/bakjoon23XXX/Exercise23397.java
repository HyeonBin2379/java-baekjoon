package bakjoon.bakjoon23XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise23397 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int now = 0;
        boolean rested = false;
        for (int i = 0; i < r; i++) {
            int next = Integer.parseInt(br.readLine());
            if (next-now >= t) {
                rested = true;
            }
            now = next;
        }

        if (rested || now + t <= d) {
            System.out.println("Y");
        } else {
            System.out.println("N");
        }
    }
}
