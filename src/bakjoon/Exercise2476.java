package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise2476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int max = 0;
        for (int i = 0; i < count; i++) {
            int[] dice = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(dice);
            int[] countAndSame = getDiffCount(dice);
            switch (countAndSame[0]) {
                case 0 -> max = Math.max(max, 10000 + countAndSame[1] * 1000);
                case 1 -> max = Math.max(max, 1000 + countAndSame[1] * 100);
                case 2 -> max = Math.max(max, dice[2] * 100);
            }
        }
        System.out.println(max);
    }

    public static int[] getDiffCount(int[] dice) {
        int[] countAndSame = {0, 0};
        for (int i = 0; i < dice.length-1; i++) {
            if (dice[i] != dice[i+1]) {
                countAndSame[0]++;
            } else {
                countAndSame[1] = Math.max(countAndSame[1], dice[i]);
            }
        }
        return countAndSame;
    }
}
