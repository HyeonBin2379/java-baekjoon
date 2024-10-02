package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Exercise1233 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dice = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, Integer> sumAndCount = new TreeMap<>();
        for (int i = 1; i <= dice[0]; i++) {
            for (int j = 1; j <= dice[1]; j++) {
                for (int k = 1; k <= dice[2]; k++) {
                    int sum = i+j+k;
                    sumAndCount.put(sum, sumAndCount.getOrDefault(sum, 0)+1);
                }
            }
        }
        List<Integer> sum = new ArrayList<>(sumAndCount.keySet());
        sum.sort((o1, o2) -> {
            if (!sumAndCount.get(o1).equals(sumAndCount.get(o2))) {
                return sumAndCount.get(o2) - sumAndCount.get(o1);
            } else {
                return o1 - o2;
            }
        });
        System.out.println(sum.get(0));
    }
}
