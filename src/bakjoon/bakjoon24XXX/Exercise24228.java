package bakjoon.bakjoon24XXX;

import java.util.Scanner;

public class Exercise24228 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong(); // 젓가락의 종류
        long r = sc.nextLong(); // 맞춰야 하는 짝의 수
        System.out.println(n+2*r-1);
    }
}
