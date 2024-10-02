package baekjoon.baekjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise4593 {

    private static final String cases = "RSP";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String player1 = br.readLine();
            String player2 = br.readLine();
            if (player1.equals("E") && player2.equals("E")) {
                break;
            }
            int n = player1.length();
            int p1 = 0, p2 = 0;
            for (int i = 0; i < n; i++) {
                int idx1 = cases.indexOf(player1.charAt(i));
                int idx2 = cases.indexOf(player2.charAt(i));
                if (player1.charAt(i) != player2.charAt(i)) {
                    if ((idx1+1) % 3 == idx2) {
                        p1++;
                    } else {
                        p2++;
                    }
                }
            }
            sb.append(String.format("P1: %d\nP2: %d\n", p1, p2));
        }
        System.out.print(sb);
    }
}
