package bakjoon.bakjoon27XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exercise27522 {

    private static final int[] scoresByRank = {10, 8, 6, 5, 4, 3, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> result = new TreeMap<>();
        for (int i = 0; i < 8; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String record = st.nextToken();
            String team = st.nextToken();
            result.put(record, team);
        }

        String[] rank = result.values().toArray(new String[0]);
        int red = 0, blue = 0;
        for (int i = 0; i < 8; i++) {
            if (rank[i].equals("B")) {
                blue += scoresByRank[i];
            } else {
                red += scoresByRank[i];
            }
        }
        System.out.println(red > blue ? "Red" : "Blue");
    }
}
