package baekjoon.baekjoon02XXX;

import java.util.Scanner;

public class Exercise2941 {

    private static final String[] croatian = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int count = 0;
        for (int i = 0; i < input.length();) {
            String temp = input.substring(i);
            i += countWord(temp);
            count++;
        }

        System.out.println(count);
    }

    private static int countWord(String subStr) {
        for (String c : croatian) {
            if (subStr.startsWith(c)) {
                return c.length();
            }
        }
        return 1;
    }
}
