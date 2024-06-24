package bakjoon.bakjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exercise15036 {
    private static final Map<Integer, Double> notes = new TreeMap<>(Map.of(
            0, 2.0,
            1 ,1.0,
            2, 1/2.0,
            4, 1/4.0,
            8, 1/8.0,
            16, 1/16.0
    ));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double sum = 0;
        for (int i = 0; i < len; i++) {
            sum += notes.get(Integer.parseInt(st.nextToken()));
        }
        System.out.printf("%.6f\n", sum);
    }
}
