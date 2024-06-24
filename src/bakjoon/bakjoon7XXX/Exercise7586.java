package bakjoon.bakjoon7XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise7586 {

    private static final Map<String, Integer> pointByType = new LinkedHashMap<>(Map.of(
            "L", 120,
            "S", 150,
            "B", 150,
            "N", 40,
            "C", 160,
            "D", 100,
            "R", 100,
            "O", 100
    ));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        while (true) {
            String flight = br.readLine();
            if (flight.equals("#")) {
                break;
            }

            Map<String, Integer> pointBySeat = new LinkedHashMap<>();
            while (true) {
                String input = br.readLine();
                if (input.equals("00A")) {
                    break;
                }

                StringTokenizer st = new StringTokenizer(input);
                String seat = st.nextToken();
                String type = st.nextToken();
                if (pointByType.containsKey(type)) {
                    pointBySeat.put(seat, pointBySeat.getOrDefault(seat, 0) + pointByType.get(type));
                }
            }
            sb.append(flight).append(" ").append(pointBySeat.values().stream().filter(point -> point >= 200).count()).append("\n");
        }
        System.out.print(sb);
    }
}
