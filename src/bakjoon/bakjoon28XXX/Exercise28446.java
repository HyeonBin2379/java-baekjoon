package bakjoon.bakjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exercise28446 {

    private static final Map<Integer, Integer> cabinet = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int request = Integer.parseInt(st.nextToken());
            int weight;

            switch (request) {
                case 1 -> {
                    int cabinetNum = Integer.parseInt(st.nextToken());
                    weight = Integer.parseInt(st.nextToken());
                    cabinet.put(weight, cabinetNum);
                }
                case 2 -> {
                    weight = Integer.parseInt(st.nextToken());
                    sb.append(cabinet.get(weight)).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
