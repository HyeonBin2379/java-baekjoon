package bakjoon;

import java.io.*;
import java.util.*;

public class Exercise30018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] before = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] after = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int needIn = 0, needOut = 0;
        for (int i = 0; i < n; i++) {
            if (before[i] == after[i]) {
                continue;
            }

            if (before[i] > after[i]) {
                needIn += before[i]-after[i];
            } else {
                needOut += Math.abs(before[i]-after[i]);
            }
        }
        System.out.println(Math.max(needIn, needOut));
    }
}
