package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise11517 {

    private static final int[] num = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals("-1 -1 -1 -1")) {
                break;
            }

            StringTokenizer st = new StringTokenizer(input);
            int index = 0;
            for (int i = 0; i < 4; i++) {
                num[i] = Integer.parseInt(st.nextToken());
                if (num[i] == -1) {
                    index = i;
                }
            }

            int result = -1;
            for (num[index] = 1; num[index] <= 10000; num[index]++) {
                if (isArithmetic() || isGeometric()) {
                    result = num[index];
                    break;
                }
            }
            System.out.println(result);
        }
    }

    private static boolean isArithmetic() {
        int d = num[1] - num[0];
        for (int i = 1; i < 4; i++) {
            if (num[i] != num[i-1] + d) {
                return false;
            }
        }
        return true;
    }

    private static boolean isGeometric() {
        int r = num[1] / num[0];
        for (int i = 1; i < 4; i++) {
            if (num[i] != num[i-1] * r) {
                return false;
            }
        }
        return true;
    }
}
