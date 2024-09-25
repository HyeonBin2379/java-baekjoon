package bakjoon.bakjoon07XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise7601 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = 0;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if (n == 0 && d == 0) {
                break;
            }
            int becRemoved = Integer.parseInt(br.readLine());
            List<Integer> bec = IntStream.rangeClosed(1, n)
                    .filter(value -> value != becRemoved)
                    .boxed()
                    .toList();

            int casRemoved = Integer.parseInt(br.readLine());
            List<Integer> cas = IntStream.rangeClosed(1, n)
                    .filter(value -> value != n-casRemoved+1)
                    .boxed()
                    .toList();

            sb.append(String.format("Scenario %d\n", ++testcase));
            for (int i = 1; i <= d; i++) {
                st = new StringTokenizer(br.readLine());
                int becChoice = Integer.parseInt(st.nextToken());
                int casChoice = Integer.parseInt(st.nextToken());
                String result = (bec.get(becChoice-1).equals(cas.get(cas.size()-casChoice)))
                        ? "ALERT"
                        : "OK";
                sb.append(String.format("Day %d %s\n", i, result));
            }
        }
        System.out.print(sb);
    }
}
