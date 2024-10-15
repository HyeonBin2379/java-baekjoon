package baekjoon.baekjoon29XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Exercise29721 {

    private static final int[][] move = {{-2, 0}, {2, 0}, {0, -2}, {0, 2}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        Set<String> onBoard = new HashSet<>();
        int[][] pos = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pos[i][0] = Integer.parseInt(st.nextToken());
            pos[i][1] = Integer.parseInt(st.nextToken());
            onBoard.add(pos[i][0] + " " + pos[i][1]);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int[] ints : move) {
                int nx = pos[i][0] + ints[0];
                int ny = pos[i][1] + ints[1];
                String key = nx + " " + ny;

                if (nx < 1 || nx > size || ny < 1 || ny > size
                        || onBoard.contains(key)) {
                    continue;
                }
                onBoard.add(key);
                count++;
            }
        }
        System.out.println(count);
    }
}
