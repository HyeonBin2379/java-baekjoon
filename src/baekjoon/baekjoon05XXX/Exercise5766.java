package baekjoon.baekjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise5766 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weeks = Integer.parseInt(st.nextToken());
            int topM = Integer.parseInt(st.nextToken());

            if (weeks == 0 && topM == 0) {
                break;
            }

            Integer[] players = new Integer[10001];
            Arrays.fill(players, 0);
            for (int i = 0; i < weeks; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < topM; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    players[num]++;
                }
            }

            int second = Arrays.stream(players)
                    .distinct()
                    .sorted(Comparator.reverseOrder())
                    .skip(1)
                    .findFirst()
                    .orElse(0);
            IntStream.rangeClosed(1, 10000)
                    .filter(index -> players[index] == second)
                    .forEach(index -> sb.append(index).append(" "));
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
