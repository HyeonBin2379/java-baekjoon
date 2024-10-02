package baekjoon.baekjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Exercise9733 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> workLog = new LinkedHashMap<>();
        String[] str = {"Re","Pt","Cc","Ea","Tb","Cm","Ex"};
        for (String work : str) {
            workLog.put(work, 0);
        }

        String input;
        int count = 0;
        while ((input = br.readLine()) != null) {
            String[] work = input.split(" ");
            for (String w : work) {
                if (workLog.containsKey(w)) {
                    workLog.put(w, workLog.getOrDefault(w, 0) + 1);
                } else {
                    count++;
                }
            }
        }
        int total = workLog.values().stream().reduce(0, Integer::sum) + count;
        workLog.forEach((key, value) -> System.out.printf("%s %d %.2f\n", key, value, (double)value/total));
        System.out.printf("Total %d 1.00\n", total);
    }
}
