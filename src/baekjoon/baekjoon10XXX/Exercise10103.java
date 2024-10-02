package baekjoon.baekjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise10103 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int c = 100, s = 100;
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dice1 = Integer.parseInt(st.nextToken());
            int dice2 = Integer.parseInt(st.nextToken());
            if (dice1 == dice2) {
                continue;
            }

            if (dice1 > dice2) {
                s -= dice1;
            } else {
                c -= dice2;
            }
        }
        System.out.println(c);
        System.out.println(s);
    }
}
