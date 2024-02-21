package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise4299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = Integer.parseInt(st.nextToken());
        int sub = Integer.parseInt(st.nextToken());
        br.close();

        if (sum < sub) {
            System.out.println(-1);
            return;
        }

        int x = Math.abs((sum+sub)) / 2;
        int y = Math.abs((sum-sub)) / 2;
        if (x+y == sum && x-y == sub) {
            System.out.println(x + " " + y);
        } else {
            System.out.println(-1);
        }
    }
}
