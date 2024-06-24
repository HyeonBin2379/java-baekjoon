package bakjoon.bakjoon5XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise5205 {
    private static class Color {
        int r, g, b;

        public Color(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            Color[] colorSet = new Color[n];
            for (int j = 0; j < n; j++) {
                int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                colorSet[j] = new Color(data[0], data[1], data[2]);
            }

            List<Integer[]> result = new ArrayList<>();
            double max = 0.0;
            for (int j = 0; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    double diff = getDiff(colorSet[j], colorSet[k]);
                    if (max < diff) {
                        max = diff;
                        result.clear();
                        result.add(new Integer[] {j+1, k+1});
                    } else if (max == diff) {
                        result.add(new Integer[] {j+1, k+1});
                    }
                }
            }

            result.sort((o1, o2) -> {
                if (!o1[0].equals(o2[0])) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            });
            sb.append(String.format("Data Set %d:\n", i));
            for (Integer[] idx : result) {
                sb.append(idx[0]).append(" ").append(idx[1]).append("\n");
            }
        }
        System.out.print(sb);
    }

    public static double getDiff(Color o1, Color o2) {
        return Math.sqrt((o1.r - o2.r)*(o1.r - o2.r) + (o1.g - o2.g)*(o1.g - o2.g) + (o1.b - o2.b)*(o1.b - o2.b));
    }
}
