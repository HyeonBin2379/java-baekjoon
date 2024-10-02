package baekjoon.baekjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise26509 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int[] tri1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(tri1);
            int[] tri2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(tri2);

            if (isRightTriangle(tri1) && isRightTriangle(tri2) && isSame(tri1, tri2)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isRightTriangle(int[] len) {
        return len[0]*len[0] + len[1]*len[1] == len[2]*len[2];
    }

    private static boolean isSame(int[] tri1, int[] tri2) {
        for (int i = 0; i < 3; i++) {
            if (tri1[i] != tri2[i]) {
                return false;
            }
        }
        return true;
    }
}
