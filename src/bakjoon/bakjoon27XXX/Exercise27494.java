package bakjoon.bakjoon27XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise27494 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 2023; i <= num; i++) {
            if (canMake2023(Integer.toString(i))) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean canMake2023(String num) {
        char[] digit = num.toCharArray();
        int len = digit.length;
        if (!hasAllNumbers(num)) {
            return false;
        }
        for (int a = 0; a < len-3; a++) {
            if (digit[a] == '2') {
                for (int b = a + 1; b < len - 2; b++) {
                    if (digit[b] == '0') {
                        for (int c = b + 1; c < len - 1; c++) {
                            if (digit[c] == '2') {
                                for (int d = c + 1; d < len; d++) {
                                    if (digit[d] == '3') {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean hasAllNumbers(String num) {
        int two = 0, zero = 0, three = 0;
        for (int i = 0; i < num.length(); i++) {
            switch (num.charAt(i)) {
                case '0' -> zero++;
                case '2' -> two++;
                case '3' -> three++;
            }
        }
        return two >= 2 && zero >= 0 && three >= 1;
    }
}
