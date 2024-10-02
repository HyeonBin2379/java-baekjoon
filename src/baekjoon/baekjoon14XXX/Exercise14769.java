package baekjoon.baekjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Exercise14769 {

    private static class Cup {
        String color;
        int radius;

        Cup(String color, int radius) {
            this.color = color;
            this.radius = radius;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Cup> cups = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = br.readLine().split(" ");

            if (tokens[0].matches("\\d+")) {
                int radius = Integer.parseInt(tokens[0]) / 2;
                String color = tokens[1];
                cups.add(new Cup(color, radius));
            } else {
                String color = tokens[0];
                int radius = Integer.parseInt(tokens[1]);
                cups.add(new Cup(color, radius));
            }
        }
        cups.stream().sorted(Comparator.comparingInt(cup -> cup.radius)).forEach(cup -> System.out.println(cup.color));
    }
}
