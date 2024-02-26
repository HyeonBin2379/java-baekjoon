package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Exercise4758 {
    private enum Position {
        WIDE_RECEIVER("Wide Receiver", 4.5, 150, 200),
        LINEMAN("Lineman", 6.0, 300, 500),
        QUARTERBACK("Quarterback", 5.0, 200, 300),
        NONE("No positions", 0, 0, 0);

        private final String name;
        private final double slowSpeed;
        private final int minWeight, minStrength;

        Position(String name, double slowSpeed, int minWeight, int minStrength) {
            this.name = name;
            this.slowSpeed = slowSpeed;
            this.minWeight = minWeight;
            this.minStrength = minStrength;
        }

        public String getName() {
            return name;
        }
        public static String getPosition(double speed, int weight, int strength) {
            String result = Arrays.stream(Position.values())
                    .filter(position -> position.isMatched(speed, weight, strength))
                    .map(position -> position.getName() + " ")
                    .collect(Collectors.joining());
            return result.isEmpty() ? NONE.getName() : result;
        }
        private boolean isMatched(double speed, int weight, int strength) {
            return speed <= this.slowSpeed
                    && weight >= this.minWeight
                    && strength >= this.minStrength;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double speed = Double.parseDouble(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            int strength = Integer.parseInt(st.nextToken());

            if (speed == 0 && weight == 0 && strength == 0) {
                break;
            }
            sb.append(Position.getPosition(speed, weight, strength)).append("\n");
        }
        System.out.print(sb);
    }
}
