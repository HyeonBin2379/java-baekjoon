package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise31628 {
    private static final String[][] eggplant = new String[10][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            eggplant[i] = br.readLine().split(" ");
        }

        for (int i = 0; i < 10; i++) {
            if (isSameCol(i) || isSameRow(i)) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    public static boolean isSameRow(int colNum) {
        for (int i = 0; i < 10; i++) {
            if (!eggplant[i][colNum].equals(eggplant[0][colNum])) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSameCol(int rowNum) {
        return Arrays.stream(eggplant[rowNum]).allMatch(s -> s.equals(eggplant[rowNum][0]));
    }
}
