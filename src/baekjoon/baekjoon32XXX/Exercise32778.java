package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise32778 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "[\\()]");
        if (st.countTokens() == 1) {
            System.out.println(st.nextToken());
            System.out.println("-");
            return;
        }
        System.out.println(st.nextToken());
        System.out.println(st.nextToken());
    }
}
