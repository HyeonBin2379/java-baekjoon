package baekjoon.baekjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise5364 {
    private static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] here = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        double min = Double.MAX_VALUE;
        for (int i = 0; i < count-1; i++) {
            int[] planet = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            double diff = getDistance(here, planet);
            if (min > diff) {
                min = diff;
                answer = Arrays.copyOf(planet, 2);
            }
        }
        System.out.println(here[0] + " " + here[1]);
        System.out.println(answer[0] + " " + answer[1]);
        System.out.printf("%.2f\n", min);
    }

    public static double getDistance(int[] here, int[] planet) {
        return Math.sqrt((here[0]-planet[0])*(here[0]-planet[0]) + (here[1]-planet[1])*(here[1]-planet[1]));
    }
}
