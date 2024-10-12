package baekjoon.baekjoon12XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise12034 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testcase; i++) {
            int n = Integer.parseInt(br.readLine());
            List<Long> prices = Arrays.stream(br.readLine().split(" "))
                    .map(Long::parseLong)
                    .toList();
            List<String> answer = new ArrayList<>();
            boolean[] visited = new boolean[2*n];
            for (int j = 0; j < 2*n; j++) {
                if (answer.size() == n) {
                    break;
                }
                if (visited[j] || prices.get(j) % 3 != 0) {
                    continue;
                }
                visited[j] = true;
                long price = (prices.get(j)/3)*4;
                for (int k = j+1; k < n*2; k++) {
                    if (!visited[k] && price == prices.get(k)) {
                        answer.add(String.valueOf(prices.get(j)));
                        visited[k] = true;
                        break;
                    }
                }
            }
            sb.append(String.format("Case #%d: %s\n", i, String.join(" ", answer)));
        }
        br.close();
        bw.write(sb.toString());
        bw.close();
    }
}