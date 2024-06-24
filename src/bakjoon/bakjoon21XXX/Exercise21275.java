package bakjoon.bakjoon21XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise21275 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String n1 = st.nextToken();
        String n2 = st.nextToken();

        List<String> result = new ArrayList<>();
        for (int a = 2; a <= 36; a++) {
            for (int b = 2; b <= 36; b++) {
                if (a == b) {
                    continue;
                }
                if (cannotUseBase(n1, a) || cannotUseBase(n2, b)) {
                    continue;
                }
                BigInteger num1 = new BigInteger(n1, a);
                BigInteger num2 = new BigInteger(n2, b);
                if (num1.equals(num2)) {
                    result.add(String.format("%d %d %d", num1, a, b));
                }
            }
        }
        if (result.isEmpty()) {
            System.out.println("Impossible");
        } else {
            System.out.println(result.size() == 1 ? result.get(0) : "Multiple");
        }
    }

    private static boolean cannotUseBase(String num, int base) {
        char[] temp = num.toCharArray();
        for (char c : temp) {
            if ((Character.isDigit(c) && c-'0' >= base)
                    || (!Character.isDigit(c) && 10 + (c - 'a') >= base)) {
                return true;
            }
        }
        return false;
    }
}
