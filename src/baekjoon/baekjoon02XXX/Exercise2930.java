package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise2930 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int round = Integer.parseInt(br.readLine());
        String sang = br.readLine();
        int n = Integer.parseInt(br.readLine());
        String[] friends = new String[n];
        for (int i = 0; i < n; i++) {
            friends[i] = br.readLine();
        }

        int result = 0;
        int best = 0;
        for (int j = 0; j < round; j++) {
            int[] cases = new int[3];
            for (int i = 0; i < n; i++) {
                result += getScore(sang.charAt(j), friends[i].charAt(j));
                cases[0] += getScore('R', friends[i].charAt(j));
                cases[1] += getScore('S', friends[i].charAt(j));
                cases[2] += getScore('P', friends[i].charAt(j));
            }
            best += Arrays.stream(cases).max().getAsInt();
        }

        System.out.println(result);
        System.out.println(best);
    }

    private static int getScore(char sang, char friend) {
        if (sang == friend) {
            return 1;
        }
        return switch (sang) {
            case 'R' -> friend == 'S' ? 2 : 0;
            case 'S' -> friend == 'P' ? 2 : 0;
            case 'P' -> friend == 'R' ? 2 : 0;
            default -> 0;
        };
    }
}
