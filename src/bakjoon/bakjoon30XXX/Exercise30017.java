package bakjoon.bakjoon30XXX;

import java.util.Scanner;

public class Exercise30017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(Math.min(2*a-1, 2*b+1));
    }
}
