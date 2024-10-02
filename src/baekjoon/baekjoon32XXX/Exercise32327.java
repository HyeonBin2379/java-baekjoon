package baekjoon.baekjoon32XXX;

import java.util.Scanner;

public class Exercise32327 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dusa = sc.nextInt();
        while (sc.hasNext()) {
            int yobis = sc.nextInt();
            if (dusa <= yobis) {
                break;
            }
            dusa += yobis;
        }
        System.out.println(dusa);
    }
}
