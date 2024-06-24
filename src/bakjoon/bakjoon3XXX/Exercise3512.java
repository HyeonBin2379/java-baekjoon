package bakjoon.bakjoon3XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise3512 {
    private static final Map<String, Integer> costTable = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int room = Integer.parseInt(st.nextToken());
        int eachCost = Integer.parseInt(st.nextToken());

        int totalSum = 0;
        for (int i = 0; i < room; i++) {
            st = new StringTokenizer(br.readLine());
            int area = Integer.parseInt(st.nextToken());
            String roomType = st.nextToken();

            totalSum += area;
            costTable.put(roomType, costTable.getOrDefault(roomType, 0)+area);
        }
        System.out.println(totalSum);
        System.out.println(costTable.getOrDefault("bedroom", 0));
        System.out.printf("%.1f\n", eachCost*(totalSum-costTable.getOrDefault("balcony", 0) + costTable.getOrDefault("balcony", 0)/2.0));
    }
}
