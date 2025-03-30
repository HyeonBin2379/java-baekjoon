package baekjoon.baekjoon01XXX;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise1316 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int count = 0;

        while (n-- > 0) {
            String input = sc.nextLine();
            if (isGroupWord(input)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean isGroupWord(String input) {
        String[] letters = Arrays.stream(input.split("")).distinct().toArray(String[]::new);

        for (String letter : letters) {
            int firstIdx = input.indexOf(letter);
            int lastIdx = input.lastIndexOf(letter);

            int count = (int) input.substring(firstIdx, lastIdx+1).chars().distinct().count();
            if (count != 1) {
                return false;
            }
        }
        return true;
    }
}
