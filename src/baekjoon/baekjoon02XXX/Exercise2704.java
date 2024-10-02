package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise2704 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] time = Arrays.stream(br.readLine().split(":"))
                    .map(Integer::parseInt)
                    .map(Integer::toBinaryString)
                    .map(Integer::parseInt)
                    .map(integer -> String.format("%06d", integer))
                    .toArray(String[]::new);

            StringBuilder threeCol = new StringBuilder();
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 3; k++) {
                    threeCol.append(time[k].charAt(j));
                }
            }

            StringBuilder threeRow = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                threeRow.append(time[j]);
            }
            sb.append(String.format("%s %s\n", threeCol, threeRow));
        }
        System.out.print(sb);
    }
}
