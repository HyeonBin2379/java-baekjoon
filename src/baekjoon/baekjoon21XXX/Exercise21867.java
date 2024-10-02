package baekjoon.baekjoon21XXX;

import java.util.Scanner;

public class Exercise21867 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String input = sc.nextLine().replaceAll("[JAV]", "");
        System.out.println(input.isEmpty() ? "nojava" : input);
    }
}
