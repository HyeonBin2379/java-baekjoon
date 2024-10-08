package baekjoon.baekjoon24XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exercise24954 {

    private static class Discount {
        int index, sale;

        public Discount(int index, int sale) {
            this.index = index;
            this.sale = sale;
        }
    }
    private static int n, answer;
    private static int[] potionPrice;
    private static boolean[] visited;
    private static final Map<Integer, List<Discount>> saleInfo = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        potionPrice = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < n; i++) {
            saleInfo.put(i, new ArrayList<>());
            int m = Integer.parseInt(br.readLine());
            while (m-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken()) - 1;
                int d = Integer.parseInt(st.nextToken());
                saleInfo.get(i).add(new Discount(idx, d));
            }
        }

        visited = new boolean[n];
        answer = Integer.MAX_VALUE;
        backtracking(0, 0);
        System.out.println(answer);
    }

    private static void backtracking(int depth, int total) {
        if (total >= answer) {
            return;
        }
        if (depth == n) {
            answer = total;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                for (Discount d : saleInfo.get(i)) {
                    potionPrice[d.index] -= d.sale;
                }
                backtracking(depth+1, total + (potionPrice[i] <= 0 ? 1 : potionPrice[i]));
                for (Discount d : saleInfo.get(i)) {
                    potionPrice[d.index] += d.sale;
                }
                visited[i] = false;
            }
        }
    }
}
