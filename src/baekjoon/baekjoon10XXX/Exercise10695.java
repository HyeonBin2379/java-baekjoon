package baekjoon.baekjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise10695 {
    private static final int[][] move = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1 ,2}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            sb.append(String.format("Case %d: ", i));
            if (canMove(n, r1, c1, r2, c2)) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.print(sb);
    }

    public static boolean canMove(int n, int r1, int c1, int r2, int c2) {
        for (int[] dir : move) {
            int nr = r1+dir[0];
            int nc = c1+dir[1];
            if (nr < 1 || nr > n || nc < 1 || nc > n ) {
                continue;
            }
            if (r1+dir[0] == r2 && c1+dir[1] == c2) {
                return true;
            }
        }
        return false;
    }
}
