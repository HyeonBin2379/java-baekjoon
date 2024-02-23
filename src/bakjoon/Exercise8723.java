package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise8723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] len = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(len);
        br.close();

        if (Math.pow(len[2], 2) == Math.pow(len[0], 2) + Math.pow(len[1], 2)) {
            System.out.println(1);
        } else if (isAllSame(len, len[0])) {
            System.out.println(2);
        } else {
            System.out.println(0);
        }
    }

    public static boolean isAllSame(int[] len, int val) {
        return Arrays.stream(len).allMatch(value -> value == val);
    }
}
