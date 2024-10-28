package baekjoon.baekjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Exercise10527 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> domJudge = new HashMap<>();
        Set<String> possible = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String result = br.readLine();
            possible.add(result);
            domJudge.merge(result, 1, Integer::sum);
        }

        Map<String, Integer> kattis = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String result = br.readLine();
            possible.add(result);
            kattis.merge(result, 1, Integer::sum);
        }

        int answer = 0;
        for (String result : possible) {
            answer += Math.min(domJudge.getOrDefault(result, 0), kattis.getOrDefault(result, 0));
        }
        System.out.println(answer);
    }
}
