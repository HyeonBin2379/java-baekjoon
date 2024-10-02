package baekjoon.baekjoon27XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise27951 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] hanger = new int[3];
        int[] type = new int[n];
        for (int i = 0; i < n; i++) {
            type[i] = Integer.parseInt(st.nextToken());
            hanger[type[i]-1]++;
        }

        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        if ((hanger[0] < u && hanger[2] < u-hanger[0]) || (hanger[1] < d && hanger[2] < d-hanger[1])) {
            System.out.println("NO");
            return;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            switch (type[i]) {
                case 1 -> answer.append("U");
                case 2 -> answer.append("D");
                case 3 -> {
                    if (u - hanger[0] > 0) {
                        answer.append("U");
                        u--;
                    } else if (d - hanger[1] > 0) {
                        answer.append("D");
                        d--;
                    }
                }
            }
        }
        System.out.println("YES");
        System.out.println(answer);
    }
}
