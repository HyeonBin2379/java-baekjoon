package bakjoon.bakjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise14582 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] woolim = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] startlink = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean hasWinning = false;
        int team1 = 0, team2 = 0;
        for (int i = 0; i < 9; i++) {
            team1 += woolim[i];
            if (team1 > team2) {
                hasWinning = true;
            }
            team2 += startlink[i];
        }
        System.out.println(team1 < team2 && hasWinning ? "Yes" : "No");
    }
}
