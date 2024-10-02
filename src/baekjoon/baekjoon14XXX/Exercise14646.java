package baekjoon.baekjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise14646 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] checked = new boolean[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0, answer = 0;
        n *= 2;
        while (n-- > 0) {
            int menuNum = Integer.parseInt(st.nextToken());
            if (checked[menuNum]) {
                count--;
                continue;
            }
            checked[menuNum] = true;
            count++;
            answer = Math.max(count, answer);
        }
        System.out.println(answer);
    }
}
