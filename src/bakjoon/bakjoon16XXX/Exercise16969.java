package bakjoon.bakjoon16XXX;

import java.util.Scanner;

public class Exercise16969 {

    private static final int MOD = (int)1E9+9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String format = sc.nextLine();
        long total = 1L;
        char before = ' ';
        for (int i = 0; i < format.length(); i++) {
            char type = format.charAt(i);
            switch (type) {
                case 'd' -> {
                    total *= (before == 'd') ? 9 : 10;
                    before = 'd';
                }
                case 'c' -> {
                    total *= (before == 'c') ? 25 : 26;
                    before = 'c';
                }
            }
            total %= MOD;
        }
        System.out.println(total);
    }
}
