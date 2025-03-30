package baekjoon.baekjoon05XXX;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise5622 {

    private static final String[] dials = {"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split("");
        System.out.println(Arrays.stream(str).mapToInt(value -> getTime(value)).sum());
    }

    public static int getTime(String letter) {
        for (int i = 2; i < dials.length; i++) {
            if (dials[i].contains(letter)) {
                return i+1;
            }
        }
        return 0;
    }
}
