package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercise1296 {
    private static final char[] love = {'L', 'O', 'V', 'E'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> result = new HashMap<>();
        String yeondu = br.readLine();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            String input = br.readLine();

            int[] count = new int[4];
            for (int j = 0; j < 4; j++) {
                int idx = j;
                count[j] += (int) input.chars().filter(value -> (char)value == love[idx]).count();
                count[j] += (int) yeondu.chars().filter(value -> (char)value == love[idx]).count();
            }

            int score = 1;
            for (int j = 0; j < 4; j++) {
                for (int k = j+1; k < 4; k++) {
                    score *= (count[j] + count[k]);
                    score %= 100;
                }
            }
            result.put(input, score);
        }

        List<Map.Entry<String, Integer>> teamName = new ArrayList<>(result.entrySet());
        teamName.sort((o1, o2) -> {
            if (o1.getValue().compareTo(o2.getValue()) != 0) {
                return o2.getValue() - o1.getValue();
            }
            return o1.getKey().compareTo(o2.getKey());
        });
        System.out.println(teamName.get(0).getKey());
    }
}
