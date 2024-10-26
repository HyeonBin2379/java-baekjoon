package baekjoon.baekjoon08XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Exercise8896 {

    private static final List<String> RSP = List.of("R", "S", "P");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[][] robots = new String[n][];
            boolean[] defeated = new boolean[n];
            for (int i = 0; i < n; i++) {
                robots[i] = br.readLine().split("");
            }

            int k = robots[0].length;
            for (int i = 0; i < k; i++) {
                String[] trial = new String[n];
                Set<String> cases = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (defeated[j]) {
                        continue;
                    }
                    trial[j] = robots[j][i];
                    cases.add(trial[j]);
                }
                if (cases.size() != 2) {
                    continue;
                }
                for (String selected : RSP) {
                    if (cases.contains(selected)) {
                        int index = (RSP.indexOf(selected)+1) % 3;
                        IntStream.range(0, n)
                                .filter(idx -> !defeated[idx] && trial[idx].equals(RSP.get(index)))
                                .forEach(idx -> defeated[idx] = true);
                    }
                }
            }

            List<Integer> result = IntStream.rangeClosed(1, n)
                    .filter(num -> !defeated[num-1])
                    .boxed()
                    .toList();
            if (result.size() == 1) {
                System.out.println(result.get(0));
            } else {
                System.out.println(0);
            }
        }
    }
}
