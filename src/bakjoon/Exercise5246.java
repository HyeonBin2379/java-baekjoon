package bakjoon;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Exercise5246 {
    private static int solve(int [] positions_x, int [] positions_y) {
        int result = 0;
        Map<Integer, List<Integer>> board = new LinkedHashMap<>();
        for (int i = 1; i <= 8; i++) {
            board.put(i, new ArrayList<>());
        }
        for (int i = 0; i < positions_y.length; i++) {
            board.get(positions_y[i]).add(positions_x[i]);
        }
        for (List<Integer> row : board.values()) {
            result = Math.max(result, row.size());
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCases = sc.nextInt();

        for(int i = 0; i < numCases; i++)
        {
            int numPieces = sc.nextInt();
            int[] positions_x = new int[numPieces];
            int[] positions_y = new int[numPieces];

            for(int j = 0; j < numPieces; j++) {
                positions_x[j] = sc.nextInt();
                positions_y[j] = sc.nextInt();
            }

            System.out.println (solve(positions_x, positions_y));
        }
    }
}
