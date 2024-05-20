package bakjoon;

import java.util.Scanner;
import java.util.Set;

public class Exercise15947 {

    private static final String[] lyric = {"baby", "sukhwan", "tururu", "turu",
            "very", "cute", "tururu", "turu",
            "in", "bed", "tururu", "turu",
            "baby", "sukhwan"};
    private static final Set<Integer> tururu = Set.of(2, 3, 6, 7, 10, 11);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (tururu.contains((n-1) % 14)) {
            String newLyric = lyric[(n-1)%14] + "ru".repeat((n-1)/14);
            int cnt = newLyric.substring(2).length()/2;
            if (cnt < 5) {
                System.out.println(newLyric);
            } else {
                System.out.printf("tu+ru*%d\n", cnt);
            }
        } else {
            System.out.println(lyric[(n-1) % 14]);
        }
    }
}
