package bakjoon.bakjoon2XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise2456 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] candidate = new int[3][4];
        int max = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int score = Integer.parseInt(st.nextToken());
                candidate[j][0] += score;
                candidate[j][score]++;
                max = Math.max(candidate[j][0], max);
            }
        }

        Map<Integer, int[]> result = new LinkedHashMap<>();
        for (int i = 0; i < 3; i++) {
            if (max == candidate[i][0]) {
                result.put(i, candidate[i]);
            }
        }
        List<Map.Entry<Integer, int[]>> answer = new ArrayList<>(result.entrySet());
        answer.sort((o1, o2) -> {
            int[] voteInfo1 = o1.getValue();
            int[] voteInfo2 = o2.getValue();
            if (voteInfo1[3] != voteInfo2[3]) {
                return voteInfo2[3]-voteInfo1[3];
            } else if (voteInfo1[2] != voteInfo2[2]) {
                return voteInfo2[2]-voteInfo1[2];
            } else {
                return voteInfo2[1]-voteInfo1[1];
            }
        });

        if (answer.size() == 1 || isNotSame(answer.get(0).getValue(), answer.get(1).getValue())) {
            System.out.println(answer.get(0).getKey()+1 + " " + max);
        } else {
            System.out.println(0 + " " + max);
        }
    }

    private static boolean isNotSame(int[] votes1, int[] votes2) {
        for (int i = 1; i <= 3; i++) {
            if (votes1[i] != votes2[i]) {
                return true;
            }
        }
        return false;
    }
}