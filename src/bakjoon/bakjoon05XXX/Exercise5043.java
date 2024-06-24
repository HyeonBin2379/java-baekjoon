package bakjoon.bakjoon05XXX;

import java.util.Scanner;

public class Exercise5043 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int b = sc.nextInt();
        System.out.println(n <= (long)Math.pow(2, b+1)-1 ? "yes" : "no");
    }
}
