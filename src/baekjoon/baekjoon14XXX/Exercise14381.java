package baekjoon.baekjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Exercise14381 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testcase; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(String.format("Case #%d: ", i));
            if (num == 0) {
                sb.append("INSOMNIA\n");
                continue;
            }
            Set<Integer> digits = new HashSet<>();
            int temp = num;
            while (true) {
                digits.addAll(Arrays.stream(Integer.toString(temp).split(""))
                        .map(Integer::parseInt)
                        .collect(Collectors.toSet()));
                if (digits.size() == 10) {
                    break;
                }
                temp += num;
            }
            sb.append(temp).append("\n");
        }
        System.out.print(sb);
    }
}
