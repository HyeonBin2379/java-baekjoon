package baekjoon.baekjoon03XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise3018 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Set<Integer>> total = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            Set<Integer> group = IntStream.range(1, 1+Integer.parseInt(input[0]))
                    .map(idx -> Integer.parseInt(input[idx]))
                    .boxed()
                    .collect(Collectors.toSet());
            if (group.contains(1)) {
                total.add(group);
                continue;
            }
            for (Set<Integer> integers : total) {
                for (int person : group) {
                    if (integers.contains(person)) {
                        integers.addAll(group);
                        break;
                    }
                }
            }
        }
        Set<Integer> result = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toSet());
        for (Set<Integer> set : total) {
            result.retainAll(set);
        }
        result.forEach(System.out::println);
    }
}
