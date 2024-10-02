package baekjoon.baekjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Exercise13698 {
    private static final int[] cup = {-1, 0, 0, 1};
    private static final Map<String, int[]> swap = new LinkedHashMap<>(Map.of(
            "A", new int[] {0, 1},
            "B", new int[] {0, 2},
            "C", new int[] {0, 3},
            "D", new int[] {1, 2},
            "E", new int[] {1, 3},
            "F", new int[] {2, 3}
    ));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] order = br.readLine().split("");
        for (String s : order) {
            int[] index = swap.get(s);
            int temp = cup[index[0]];
            cup[index[0]] = cup[index[1]];
            cup[index[1]] = temp;
        }

        int min = 0, max = 0;
        for (int i = 0; i < 4; i++) {
            if (cup[i] == 0) {
                continue;
            }

            if (cup[i] < 0) {
                min = i+1;
            } else {
                max = i+1;
            }
        }
        System.out.println(min);
        System.out.println(max);
    }
}
