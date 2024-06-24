package bakjoon.bakjoon03XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise3234 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] luka = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(br.readLine());
        char[] move = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();
        int[] tester = new int[2];
        if (isNear(tester, luka)) {
            sb.append(0).append("\n");
        }
        for (int i = 0; i < k; i++) {
            switch (move[i]) {
                case 'I' -> tester[0]++;
                case 'S' -> tester[1]++;
                case 'Z' -> tester[0]--;
                case 'J' -> tester[1]--;
            }
            if (isNear(tester, luka)) {
                sb.append(i+1).append("\n");
            }
        }
        System.out.print(sb.isEmpty() ? -1 : sb);
    }

    private static boolean isNear(int[] tester, int[] luka) {
        int[] x = {0, -1, 1, 0, 0, -1, 1, -1, 1};
        int[] y = {0, 0, 0, -1, 1, -1, -1, 1, 1};

        for (int i = 0; i < 9; i++) {
            int nx = tester[0]+x[i];
            int ny = tester[1]+y[i];

            if (nx == luka[0] && ny == luka[1]) {
                return true;
            }
        }
        return false;
    }
}
