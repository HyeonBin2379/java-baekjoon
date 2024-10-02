package baekjoon.baekjoon32XXX;

import java.util.Scanner;

public class Exercise32369 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        int good = 0;
        int[] onion = {1, 1};
        for (int i = 1; i <= n; i++) {
            onion[good] += a;
            onion[(good+1)%2] += b;
            if (onion[good] < onion[(good+1)%2]) {
                good = (good+1) % 2;
            }
            if (onion[good] == onion[(good+1)%2]) {
                onion[(good+1)%2]--;
            }
        }
        System.out.println(onion[good] + " " + onion[(good+1)%2]);
    }
}
