package baekjoon.baekjoon23XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise23568 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Long, Long> nextMove = new HashMap<>();
        long n = Long.parseLong(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long position = Long.parseLong(st.nextToken());
            String direction = st.nextToken();
            long distance = Long.parseLong(st.nextToken());
            if (direction.equals("L")) {
                distance *= -1;
            }
            nextMove.put(position, distance);
        }
        long now = Long.parseLong(br.readLine());
        while (nextMove.containsKey(now)) {
            now += nextMove.get(now);
        }
        System.out.println(now);
    }
}
