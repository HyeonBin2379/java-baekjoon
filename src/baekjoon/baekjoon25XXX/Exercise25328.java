package baekjoon.baekjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Exercise25328 {

    private static final Map<String, Integer> map = new TreeMap<>();
    private static int k;
    private static char[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = new String[3];
        for (int i = 0; i < 3; i++) {
            input[i] = br.readLine();
        }

        // 나올 수 있는 부분문자열 구하기
        k = Integer.parseInt(br.readLine());
        selected = new char[k];
        for (int i = 0; i < 3; i++) {
            combine(0, 0, input[i]);
        }

        List<String> result = new ArrayList<>();
        map.keySet().stream().filter(s -> map.get(s) >= 2).forEach(result::add);
        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            result.forEach(System.out::println);
        }
    }

    private static void combine(int cnt, int start, String s) {
        if (cnt == k) {
            // 동일한 문자열이 이미 존재하면 개수 합산
            map.merge(String.valueOf(selected), 1, Integer::sum);
            return;
        }
        // 부분문자열 구하기
        for (int i = start; i < s.length(); i++) {
            selected[cnt] = s.charAt(i);
            combine(cnt+1, i+1, s);
        }
    }
}
