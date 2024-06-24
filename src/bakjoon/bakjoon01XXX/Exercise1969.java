package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class Exercise1969 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int dnaCount = Integer.parseInt(st.nextToken());
        int dnaLength = Integer.parseInt(st.nextToken());

        String[] dna = new String[dnaCount];
        for (int i = 0; i < dnaCount; i++) {
            dna[i] = br.readLine();
        }
        br.close();

        StringBuilder result = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < dnaLength; i++) {
            Map<Character, Integer> nucleotide = new HashMap<>();
            for (int j = 0; j < dnaCount; j++) {
                nucleotide.put(dna[j].charAt(i), nucleotide.getOrDefault(dna[j].charAt(i), 0)+1);
            }

            List<Map.Entry<Character, Integer>> sorted = new ArrayList<>(nucleotide.entrySet());
            sorted.sort((o1, o2) -> {
                if (!Objects.equals(o1.getValue(), o2.getValue())) {
                    return o2.getValue() - o1.getValue();
                }
                return o1.getKey().compareTo(o2.getKey());
            });
            sum += (dnaCount - sorted.get(0).getValue());
            result.append(sorted.get(0).getKey());
        }
        System.out.println(result);
        System.out.println(sum);
    }
}
