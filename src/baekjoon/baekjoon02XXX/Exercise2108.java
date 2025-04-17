package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Exercise2108 {

    private static final Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            map.merge(arr[i], 1, Integer::sum);
            maxCount = Math.max(map.get(arr[i]), maxCount);
        }
        Arrays.sort(arr);

        List<Integer> mostFreq = getList(maxCount);
        System.out.println(Math.round((double)Arrays.stream(arr).sum()/n));
        System.out.println(arr[n/2]);
        System.out.println(mostFreq.size() > 1 ? mostFreq.get(1) : mostFreq.get(0));
        System.out.println(arr[n-1]-arr[0]);
    }

    private static List<Integer> getList(int target) {
        return map.entrySet().stream()
                .filter(val -> val.getValue() == target)
                .map(Entry::getKey)
                .sorted()
                .collect(Collectors.toList());
    }
}
