package bakjoon.bakjoon29XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exercise29738 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 1; i <= testCase; i++) {
            int rank = Integer.parseInt(br.readLine());
            bw.write(String.format("Case #%d: %s\n", i, getNextRound(rank)));
        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static String getNextRound(int rank) {
        if (rank <= 25) {
            return "World Finals";
        } else if (rank <= 1000) {
            return "Round 3";
        } else if (rank <= 4500) {
            return "Round 2";
        } else {
            return "Round 1";
        }
    }
}
