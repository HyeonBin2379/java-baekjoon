package baekjoon.baekjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise14564 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken())-1;

        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == m/2+1) {
                System.out.println(0);
                break;
            }
            a = (a+n+num - (m/2+1)) % n;
            System.out.println(a+1);
        }
    }
}
