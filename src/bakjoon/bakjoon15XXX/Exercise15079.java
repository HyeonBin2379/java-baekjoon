package bakjoon.bakjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise15079 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[] now = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String dir = st.nextToken();
            int dist = Integer.parseInt(st.nextToken());
            if (dir.length() == 1) {
                switch (dir) {
                    case "N" -> now[1] += dist;
                    case "S" -> now[1] -= dist;
                    case "W" -> now[0] -= dist;
                    case "E" -> now[0] += dist;
                }
            } else {
                double newDist = Math.sqrt(Math.pow(dist, 2)/2);
                switch (dir) {
                    case "NE" -> {
                        now[0] += newDist;
                        now[1] += newDist;
                    }
                    case "SE" -> {
                        now[0] += newDist;
                        now[1] -= newDist;
                    }
                    case "NW" -> {
                        now[0] -= newDist;
                        now[1] += newDist;
                    }
                    case "SW" -> {
                        now[0] -= newDist;
                        now[1] -= newDist;
                    }
                }
            }
        }
        System.out.printf("%.6f %.6f\n", now[0], now[1]);
    }
}
