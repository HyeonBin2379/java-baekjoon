package bakjoon.bakjoon24XXX;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise24606 {
    private static int[] pwd1, pwd2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        pwd1 = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        pwd2 = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();

        int count = 0;
        for (int a = 0; a < 10; a++) {
            for (int b = 0; b < 10; b++) {
                for (int c = 0; c < 10; c++) {
                    for (int d = 0; d < 10; d++) {
                        int[] num = {a, b, c, d};
                        if (isAnyMatched(num)) {
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static boolean isAnyMatched(int[] num) {
        for (int i = 0; i < 4; i++) {
            if (num[i] != pwd1[i] && num[i] != pwd2[i]) {
                return false;
            }
        }
        return true;
    }
}
