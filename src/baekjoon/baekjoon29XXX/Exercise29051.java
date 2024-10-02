package baekjoon.baekjoon29XXX;

import java.util.Scanner;

public class Exercise29051 {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int[] count = {2,1,1,1,2,2,1,3,3,2,3,1,1,1,1,1,1,2,1,2,1,1,1,2,2,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int total = 0;
        for (String letter : input.split("")) {
            total += count[ALPHABET.indexOf(letter)];
        }
        System.out.println(total);
    }
}
