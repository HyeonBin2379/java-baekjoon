package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise1092 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> crane = Arrays.stream(br.readLine().split(" ", n))
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .toList();
        int m = Integer.parseInt(br.readLine());
        List<Integer> box = Arrays.stream(br.readLine().split(" ", m))
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        if (!crane.isEmpty() && !box.isEmpty() && crane.get(0) < box.get(0)) {
            System.out.println(-1);
            return;
        }

        int result = 0;
        while (!box.isEmpty()) {
            result += 1;
            for (Integer currCrane : crane) {
                for (int j = 0; j < box.size(); j++) {
                    if (currCrane >= box.get(j)) {
                        box.remove(j);
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
