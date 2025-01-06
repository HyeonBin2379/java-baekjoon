package baekjoon.baekjoon33XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise33026 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        for (int i = 1; i <= n; i++) {
            String str1 = str.substring(0, i);
            String str2 = str.substring(i);

            if (check(str1, str2)) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }

    private static boolean check(String str1, String str2) {
        int bread1 = (int) str1.chars().filter(s -> (char)s == 'L').count();
        int onion1 = (int) str1.chars().filter(s -> (char)s == 'O').count();
        if (bread1+onion1 == 0) {
            return false;
        }

        int bread2 = (int) str2.chars().filter(s -> (char)s == 'L').count();
        int onion2 = (int) str2.chars().filter(s -> (char)s == 'O').count();
        if (bread2+onion2 == 0) {
            return false;
        }

        return (bread1 != bread2) && (onion1 != onion2);
    }
}
