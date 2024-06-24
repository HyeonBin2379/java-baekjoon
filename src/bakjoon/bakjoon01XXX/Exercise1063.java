package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise1063 {

    private static final Map<String, Integer[]> move = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] temp1 = st.nextToken().split("");
        int[] king = new int[]{Integer.parseInt(temp1[1]) - 1, temp1[0].charAt(0) - 'A'};
        String[] temp2 = st.nextToken().split("");
        int[] stone = new int[]{Integer.parseInt(temp2[1]) - 1, temp2[0].charAt(0) - 'A'};
        int moveCnt = Integer.parseInt(st.nextToken());

        setMove();
        for (int i = 0; i < moveCnt; i++) {
            Integer[] next = move.get(br.readLine());
            int nc_king = king[0] + next[0];
            int nr_king = king[1] + next[1];

            if (nr_king < 0 || nr_king >= 8 || nc_king < 0 || nc_king >= 8) {
                continue;
            }
            if (nc_king == stone[0] && nr_king == stone[1]) {
                int nc_stone = stone[0] + next[0];
                int nr_stone = stone[1] + next[1];

                if (nr_stone < 0 || nr_stone >= 8 || nc_stone < 0 || nc_stone >= 8) {
                    continue;
                }
                stone = new int[] {nc_stone, nr_stone};
            }
            king = new int[] {nc_king, nr_king};
        }
        System.out.printf("%c%d\n", (char)(king[1]+'A'), king[0]+1);
        System.out.printf("%c%d\n", (char)(stone[1]+'A'), stone[0]+1);
    }

    private static void setMove() {
        move.put("R", new Integer[] {0, 1});
        move.put("L", new Integer[] {0, -1});
        move.put("B", new Integer[] {-1, 0});
        move.put("T", new Integer[] {1, 0});
        move.put("RT", new Integer[] {1, 1});
        move.put("LT", new Integer[] {1, -1});
        move.put("RB", new Integer[] {-1, 1});
        move.put("LB", new Integer[] {-1, -1});
    }
}
