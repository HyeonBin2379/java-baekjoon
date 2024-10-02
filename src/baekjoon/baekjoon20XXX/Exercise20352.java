package baekjoon.baekjoon20XXX;

import java.util.Scanner;

public class Exercise20352 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long area = sc.nextLong();
        System.out.printf("%.10f", Math.PI * Math.sqrt(area/Math.PI) * 2);
    }
}
