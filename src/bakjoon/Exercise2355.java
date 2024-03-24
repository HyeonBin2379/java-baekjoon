package bakjoon;

import java.util.Scanner;

public class Exercise2355 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long sum = (a + b) * (Math.max(a,b)-Math.min(a, b)+1)/2;
        System.out.println(sum);
    }
}
