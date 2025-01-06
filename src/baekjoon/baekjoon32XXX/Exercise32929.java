package baekjoon.baekjoon32XXX;

import java.util.Scanner;

public class Exercise32929 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        switch (num % 3) {
            case 0 -> System.out.println("S");
            case 1 -> System.out.println("U");
            case 2 -> System.out.println("O");
        }
    }
}
