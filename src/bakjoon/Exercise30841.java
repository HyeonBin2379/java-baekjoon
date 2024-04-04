package bakjoon;

import java.util.Scanner;

public class Exercise30841 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        System.out.println((a+b == 0) ? a*b : a*b/(a+b));
    }
}
