package bakjoon.bakjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise25870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int first = 0, second = 0;
        int votes1 = 0, votes2 = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int e = Integer.parseInt(st.nextToken());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            if (v1 > v2) {
                first += e;
            } else {
                second += e;
            }
            votes1 += v1;
            votes2 += v2;
        }

        if (first > second && votes1 > votes2) {
            System.out.println(1);
        } else if (first < second && votes1 < votes2) {
            System.out.println(2);
        } else {
            System.out.println(0);
        }
    }
}
