package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Exercise32386 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> tagCnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] info = br.readLine().split(" ");
            int cnt = Integer.parseInt(info[1]);
            IntStream.range(2, 2+cnt).forEach(idx -> tagCnt.merge(info[idx], 1, Integer::sum));
        }
        int max = tagCnt.values().stream().reduce(0, Integer::max);
        List<String> result = tagCnt.keySet().stream()
                .filter(s -> tagCnt.get(s) == max)
                .limit(2)
                .toList();
        System.out.println(result.size() > 1 ? -1 : result.get(0));
    }
}
