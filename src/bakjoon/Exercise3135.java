package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise3135 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        int minMove = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int button = Integer.parseInt(br.readLine());
            minMove = Math.min(minMove, Math.abs(button-b) + 1);
        }
        System.out.println(Math.min(minMove, Math.abs(a-b)));
    }
}
