package baekjoon.baekjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise13608 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            int pairCnt = 0;
            while (n-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int len = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                pairCnt += cnt/2;
            }
            System.out.println(pairCnt / 2);
        }
    }
}
