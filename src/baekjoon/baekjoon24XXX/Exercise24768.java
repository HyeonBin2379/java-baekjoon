package baekjoon.baekjoon24XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise24768 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals("0 0")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(input);
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x+y == 13) {
                System.out.println("Never speak again.");
                continue;
            }

            if (x > y) {
                System.out.println("To the convention.");
            } else if (x == y) {
                System.out.println("Undecided.");
            } else {
                System.out.println("Left beehind.");
            }
        }
    }
}
