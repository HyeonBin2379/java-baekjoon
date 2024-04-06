package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Exercise26863 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> height = new TreeMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            int h = Integer.parseInt(br.readLine());
            min = Math.min(h, min);
            height.put(h, height.getOrDefault(h, 0)+1);
        }
        int pad = Integer.parseInt(br.readLine());
        switch (height.get(min)) {
            case 1 -> {
                int max = height.keySet().stream().max(Comparator.comparingInt(o -> o)).get();
                System.out.println((min + pad == max) ? 1 : 0);
            }
            case 2, 3 -> System.out.println(0);
            case 4 -> System.out.println(1);
        }
    }
}
