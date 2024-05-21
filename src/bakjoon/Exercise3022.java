package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Exercise3022 {

    private static final Map<String, Integer> amount = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int warning = 0;
        int totalTaken = 0;
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            if (totalTaken++ - amount.getOrDefault(name, 0) < amount.getOrDefault(name, 0)) {
                warning++;
            }
            amount.put(name, amount.getOrDefault(name, 0)+1);
        }
        System.out.println(warning);
    }
}
