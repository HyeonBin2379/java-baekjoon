package bakjoon.bakjoon18XXX;

import java.util.Scanner;

public class Exercise18512 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int p1 = sc.nextInt();
        int p2 = sc.nextInt();
        sc.close();

        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                int pos1 = p1+x*i;
                int pos2 = p2+y*j;
                if (pos1 == pos2) {
                    System.out.println(pos1);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}
