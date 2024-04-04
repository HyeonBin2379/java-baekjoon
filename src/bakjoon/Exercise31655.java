package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise31655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] date = Arrays.stream(br.readLine().split("/")).mapToInt(Integer::parseInt).toArray();

        if (canBeMonth(date[0]) && canBeMonth(date[1])) {
            System.out.println("either");
        } else if (!canBeMonth(date[0])) {
            System.out.println("EU");
        } else if (!canBeMonth(date[1])) {
            System.out.println("US");
        }
    }

    public static boolean canBeMonth(int num) {
        return num >= 1 && num <= 12;
    }
}
