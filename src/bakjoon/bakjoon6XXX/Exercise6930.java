package bakjoon.bakjoon6XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise6930 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int answer = m;
        for (int i = 0; i < m; i++) {
            if (x*i % m == 1) {
                answer = i;
            }
        }
        System.out.println(answer == m ? "No such integer exists." : answer);
    }
}
