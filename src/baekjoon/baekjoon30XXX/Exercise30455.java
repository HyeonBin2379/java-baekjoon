package baekjoon.baekjoon30XXX;

import java.util.Scanner;

public class Exercise30455 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n % 2 == 1 ? "Goose" : "Duck");
    }
}
