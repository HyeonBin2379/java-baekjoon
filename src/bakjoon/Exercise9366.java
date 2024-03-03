package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise9366 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            int[] len = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(len);
            int count = (int) Arrays.stream(len).filter(value -> value == len[1]).count();

            if (len[0]+len[1] <= len[2]) {
                sb.append(String.format("Case #%d: invalid!\n", i));
                continue;
            }

            switch (count) {
                case 1 -> sb.append(String.format("Case #%d: scalene\n", i));
                case 2 -> sb.append(String.format("Case #%d: isosceles\n", i));
                case 3 -> sb.append(String.format("Case #%d: equilateral\n", i));
            }
        }
        System.out.print(sb);
    }
}
