package baekjoon.baekjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise28455 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] level = new int[n];
        for (int i = 0; i < n; i++) {
            level[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(level);

        int levelSum = 0;
        int increased = 0;
        for (int i = 0; i < Math.min(n, 42); i++) {
            levelSum += level[n-1-i];
            increased += getBonus(level[n-1-i]);
        }
        System.out.println(levelSum + " " + increased);
    }

    private static int getBonus(int level) {
        if (level >= 250) {
            return 5;
        } else if (level >= 200) {
            return 4;
        } else if (level >= 140) {
            return 3;
        } else if (level >= 100) {
            return 2;
        } else if (level >= 60) {
            return 1;
        } else {
            return 0;
        }
    }
}
