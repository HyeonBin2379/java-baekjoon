package bakjoon.bakjoon8XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise8714 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int front = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < len; i++) {
            int coin = Integer.parseInt(st.nextToken());
            front += (coin == 0) ? 1 : 0;
        }
        System.out.println(Math.min(front, len-front));
    }
}
