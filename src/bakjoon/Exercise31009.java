package bakjoon;

import java.io.*;
import java.util.*;

public class Exercise31009 {
    private static final Map<String, Integer> ticket = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String dest = st.nextToken();
            int cost = Integer.parseInt(st.nextToken());
            ticket.put(dest, cost);
        }
        int jinju = ticket.get("jinju");
        System.out.println(jinju);
        System.out.println(ticket.values().stream()
                .filter(integer -> integer > jinju)
                .count());
    }
}
