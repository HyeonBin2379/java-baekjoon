package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise2712 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double value = Double.parseDouble(st.nextToken());
            String unit = st.nextToken();
            switch (unit) {
                case "kg" -> {
                    value *= 2.2046;
                    sb.append(String.format("%.4f lb\n", value));
                }
                case "lb" -> {
                    value *= 0.4536;
                    sb.append(String.format("%.4f kg\n", value));
                }
                case "l" -> {
                    value *= 0.2642;
                    sb.append(String.format("%.4f g\n", value));
                }
                case "g" -> {
                    value *= 3.7854;
                    sb.append(String.format("%.4f l\n", value));
                }
            }
        }
        System.out.print(sb);
    }
}
