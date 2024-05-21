package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Exercise16499 {

    private static final Map<String, List<String>> wordSet = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            String key = Arrays.stream(word.split("")).sorted().collect(Collectors.joining());
            if (!wordSet.containsKey(key)) {
                wordSet.put(key, new ArrayList<>());
            }
            wordSet.get(key).add(word);
        }
        System.out.println(wordSet.size());
    }
}
