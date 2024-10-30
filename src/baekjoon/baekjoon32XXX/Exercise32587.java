package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Exercise32587 {

    private static final List<String> RSP = List.of("R", "S", "P");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] player = br.readLine().split("");
        String[] opponent = br.readLine().split("");

        int win = 0, lose = 0;
        for (int i = 0; i < n; i++) {
            if (player[i].equals(opponent[i])) {
                continue;
            }
            if ((RSP.indexOf(player[i])+1) % 3 == RSP.indexOf(opponent[i])) {
                win++;
            } else {
                lose++;
            }
        }
        System.out.println(win > lose ? "victory" : "defeat");
    }
}
