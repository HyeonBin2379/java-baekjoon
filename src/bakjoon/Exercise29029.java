package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Exercise29029 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> dirCount = new HashMap<>();
        int len = Integer.parseInt(br.readLine().trim());
        String[] dir = br.readLine().split("");

        for (int i = 0; i < len; i++) {
            dirCount.put(dir[i], dirCount.getOrDefault(dir[i], 0)+1);
        }
        int max = dirCount.values().stream().max(Comparator.comparingInt(o -> o)).get();
        System.out.println(len-max);
    }
}
