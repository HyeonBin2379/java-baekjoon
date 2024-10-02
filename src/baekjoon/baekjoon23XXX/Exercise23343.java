package baekjoon.baekjoon23XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise23343 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String x = st.nextToken();
        x = isNotNumber(x) ? "NaN" : x;

        String y = st.nextToken();
        y = isNotNumber(y) ? "NaN" : y;

        if (x.equals("NaN") || y.equals("NaN")) {
            System.out.println("NaN");
        } else {
            System.out.println(Integer.parseInt(x) - Integer.parseInt(y));
        }
    }

    private static boolean isNotNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
