package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exercise2484 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] prize = new Integer[n];

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> diceLog = new TreeMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int diceNum = Integer.parseInt(st.nextToken());
                diceLog.put(diceNum, diceLog.getOrDefault(diceNum, 0)+1);
            }

            List<Integer> diceNum = new ArrayList<>(diceLog.keySet());
            diceNum.sort((o1, o2) -> {
                if (!diceLog.get(o1).equals(diceLog.get(o2))) {
                    return diceLog.get(o2)-diceLog.get(o1);
                } else {
                    return o2-o1;
                }
            });

            switch (diceLog.size()) {
                case 1 -> prize[i] = 50000 + diceNum.get(0) * 5000;
                case 2 -> {
                    int max = diceLog.values().stream().max(Comparator.comparingInt(o -> o)).get();
                    if (max == 3) {
                        prize[i] = 10000 + diceNum.get(0) * 1000;
                    } else if (max == 2) {
                        prize[i] = 2000 + (diceNum.get(0) + diceNum.get(1)) * 500;
                    }
                }
                case 3 -> prize[i] = 1000 + diceNum.get(0) * 100;
                case 4 -> prize[i] = diceNum.get(0) * 100;
            }
        }
        System.out.println(Arrays.stream(prize).max(Comparator.comparingInt(o -> o)).get());
    }
}
