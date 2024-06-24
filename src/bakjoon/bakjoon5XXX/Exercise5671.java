package bakjoon.bakjoon5XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise5671 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            int[] roomNum = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            int count = roomNum[1] - roomNum[0] + 1;
            for (int i = roomNum[0]; i <= roomNum[1]; i++) {
                if (hasSameNumber(String.valueOf(i))) {
                    count--;
                }
            }
            System.out.println(count);
        }
    }

    public static boolean hasSameNumber(String num) {
        for (int i = 0; i < num.length()-1; i++) {
            for (int j = i+1; j < num.length(); j++) {
                if (num.charAt(i) == num.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }
}
