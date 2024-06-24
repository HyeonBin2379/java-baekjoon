package bakjoon.bakjoon25XXX;

import java.util.Scanner;

public class Exercise25238 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println((a*(100-b)/100) >= 100 ? 0 : 1);
    }
}
