package bakjoon.bakjoon25XXX;

import java.util.Scanner;

public class Exercise25625 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.close();
        System.out.println((x > y) ? x+y : y-x);
    }
}
