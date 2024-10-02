package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise1270 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Map<Long, Integer> state = new HashMap<>();
            String answer = "SYJKGW";
            int half = Integer.parseInt(st.nextToken()) / 2;
            while (st.hasMoreTokens()) {
                long num = Long.parseLong(st.nextToken());
                if (state.getOrDefault(num, 0)+1 > half) {
                    answer = Long.toString(num);
                    break;
                }
                state.put(num, state.getOrDefault(num, 0)+1);
            }
            System.out.println(answer);
        }
    }
}
