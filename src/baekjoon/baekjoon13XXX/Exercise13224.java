package baekjoon.baekjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Exercise13224 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, int[]> swap = new TreeMap<>(Map.of(
           'A', new int[] {0, 1},
           'B', new int[] {1, 2},
           'C', new int[] {0, 2}
        ));
        int[] cup = {1, 0, 0};
        char[] order = br.readLine().toCharArray();
        for (char c : order) {
            int[] index = swap.get(c);
            int temp = cup[index[0]];
            cup[index[0]] = cup[index[1]];
            cup[index[1]] = temp;
        }

        for (int i = 0; i < 3; i++) {
            if (cup[i] == 1) {
                System.out.println(i+1);
                break;
            }
        }
    }
}
