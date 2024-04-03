package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise20877 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = 0;
        for (int i = 0; i < n; i++) {
            int stroke = Math.min(Integer.parseInt(st.nextToken()), 7);
            total += (i % 2 == 0) ? stroke-2 : stroke-3;
        }
        System.out.println(total);
    }
}
