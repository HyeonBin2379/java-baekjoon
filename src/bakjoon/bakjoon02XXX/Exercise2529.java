package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise2529 {

    private static int n;
    private static String max = "", min = "";
    private static String[] sign;
    private static final boolean[] visited = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sign = br.readLine().split(" ");

        findMatchedSequence(0, "");
        System.out.println(max);
        System.out.println(min);
    }

    private static void findMatchedSequence(int count, String selected) {
        if (count == n+1) {
            if (min.isEmpty()) {
                min = selected;
            } else {
                max = selected;
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (count == 0 || check(selected.charAt(count-1), (char) (i+'0'), sign[count-1])) {
                if (!visited[i]) {
                    visited[i] = true;
                    findMatchedSequence(count + 1, selected + i);
                    visited[i] = false;
                }
            }
        }
    }
    private static boolean check(char lastNum, char newNum, String sign) {
        return sign.equals("<") ? lastNum < newNum : lastNum > newNum;
    }
}
