package bakjoon.bakjoon11XXX;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise11948 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] sci_score = new int[4];
        int[] social_score = new int[2];
        for (int i = 0; i < 6; i++) {
            if (i < 4) {
                sci_score[i] = sc.nextInt();
            } else {
                social_score[i-4] = sc.nextInt();
            }
        }
        Arrays.sort(sci_score);

        int total = Arrays.stream(sci_score).sum() - sci_score[0];
        total += Math.max(social_score[0], social_score[1]);
        System.out.println(total);
    }
}
