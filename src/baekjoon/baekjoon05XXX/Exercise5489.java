package baekjoon.baekjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercise5489 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, Long> frequencyMap = br.lines()
                .limit(N)
                .map(Integer::parseInt)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        int result = frequencyMap.entrySet()
                .stream()
                .max((e1, e2) -> {
                    int cmp = e1.getValue().compareTo(e2.getValue());
                    if (cmp == 0) {
                        return Integer.compare(e2.getKey(), e1.getKey());
                    } else {
                        return cmp;
                    }
                })
                .get()
                .getKey();

        System.out.println(result);
    }
}
