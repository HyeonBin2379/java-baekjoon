package bakjoon.bakjoon1XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercise1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        Map<String, Integer> salesLog = new HashMap<>();
        for (int i = 0; i < count; i++) {
            String book = br.readLine();
            salesLog.put(book, salesLog.getOrDefault(book, 0)+1);
        }
        br.close();

        List<Map.Entry<String, Integer>> entrySet = new ArrayList<>(salesLog.entrySet());
        entrySet.sort((o1, o2) -> {
            if (!o1.getValue().equals(o2.getValue())) {
                return o2.getValue() - o1.getValue();
            }
            return o1.getKey().compareTo(o2.getKey());
        });
        System.out.println(entrySet.get(0).getKey());
    }
}
