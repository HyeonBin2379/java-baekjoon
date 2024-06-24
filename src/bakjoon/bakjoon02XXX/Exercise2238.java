package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise2238 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        Map<Integer, Queue<String>> auction = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int cost = Integer.parseInt(st.nextToken());
            if (cost > u) {
                continue;
            }
            if (!auction.containsKey(cost)) {
                auction.put(cost, new LinkedList<>());
            }
            auction.get(cost).add(name);
        }

        Map.Entry<Integer, Queue<String>> result = auction.entrySet().stream().min(
                (o1, o2) -> {
                    if (o1.getValue().size() != o2.getValue().size()) {
                        return o1.getValue().size() - o2.getValue().size();
                    } else {
                        return o1.getKey() - o2.getKey();
                    }
                })
                .get();
        System.out.println(result.getValue().peek() + " " + result.getKey());
    }
}
