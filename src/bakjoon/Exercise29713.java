package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Exercise29713 {

    private static final Map<Character, Integer> oneSeal = new TreeMap<>(Map.of(
            'B', 1,
            'R', 2,
            'O', 1,
            'N', 1,
            'Z', 1,
            'E', 2,
            'S', 1,
            'I', 1,
            'L', 1,
            'V', 1
    ));
    private static final Map<Character, Integer> letterCnt = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] input = br.readLine().chars()
                .filter(value -> oneSeal.containsKey((char)value))
                .mapToObj(ch -> String.valueOf((char)ch))
                .sorted()
                .collect(Collectors.joining())
                .toCharArray();

        for (char c : input) {
            letterCnt.put(c, letterCnt.getOrDefault(c, 0) + 1);
        }
        letterCnt.put('E', letterCnt.getOrDefault('E', 0) / 2);
        letterCnt.put('R', letterCnt.getOrDefault('R', 0) / 2);
        System.out.println(letterCnt.values().stream().min(Comparator.comparingInt(value -> value)).get());
    }
}