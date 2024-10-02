package baekjoon.baekjoon29XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Exercise29097 {

    private static final String[] KINGS = {"Joffrey", "Robb", "Stannis"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<String, Integer> troopByKing = new TreeMap<>();
        for (int i = 0; i < 3; i++) {
            troopByKing.put(KINGS[i], data[i]*data[i+3]);
        }
        int max = troopByKing.values().stream().reduce(0, Integer::max);
        System.out.println(troopByKing.entrySet().stream()
                .sorted((o1, o2) -> !o1.getValue().equals(o2.getValue()) ?
                        Integer.compare(o2.getValue(), o1.getValue()) : o1.getKey().compareTo(o2.getKey()))
                .filter(entry -> entry.getValue() == max)
                .map(Entry::getKey)
                .collect(Collectors.joining(" ")));
    }
}
