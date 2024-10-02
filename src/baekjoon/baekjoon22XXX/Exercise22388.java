package baekjoon.baekjoon22XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise22388 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals("#")) {
                break;
            }

            StringTokenizer st = new StringTokenizer(input);
            String g = st.nextToken();
            int y = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if (y > 31 || (y == 31 && m >= 5)) {
                System.out.println("?" + " " + (y-30) + " " + m + " " + d);
            } else {
                System.out.println(g + " " + y + " " + m + " " + d);
            }
        }
    }
}
