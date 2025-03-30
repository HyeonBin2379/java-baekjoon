package baekjoon.baekjoon10XXX;

import java.util.Scanner;

public class Exercise10988 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] input = sc.nextLine().toCharArray();

        for (int i = 0; i < input.length/2; i++) {
            if (input[i] != input[input.length-1-i]) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}
