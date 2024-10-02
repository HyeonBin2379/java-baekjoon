package baekjoon.baekjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise15889 {

    private static int n;
    private static int[] pos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        pos = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if (canReach(br.readLine())) {
            System.out.println("권병장님, 중대장님이 찾으십니다");
        } else {
            System.out.println("엄마 나 전역 늦어질 것 같아");
        }
    }

    private static boolean canReach(String input) {
        if (n == 1) {
            return true;
        }
        StringTokenizer st = new StringTokenizer(input);
        int maxRange = 0;
        for (int i = 0; i < n-1; i++) {
            int range = Integer.parseInt(st.nextToken());
            if (pos[i] + range > maxRange) {
                maxRange = pos[i] + range;
            }
            if (maxRange < pos[i+1]) {
                return false;
            }
        }
        return true;
    }
}
