package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise14761 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            if (i % x == 0 || i % y == 0) {
                if (i % x == 0) {
                    System.out.print("Fizz");
                }
                if (i % y == 0) {
                    System.out.print("Buzz");
                }
                System.out.println();
            } else {
                System.out.println(i);
            }
        }
    }
}
