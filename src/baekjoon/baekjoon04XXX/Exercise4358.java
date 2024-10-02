package baekjoon.baekjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Exercise4358 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> tree = new TreeMap<>();
        String treeName;
        while ((treeName = br.readLine()) != null) {
            tree.put(treeName, tree.getOrDefault(treeName, 0)+1);
        }
        int total = tree.values().stream().reduce(0, Integer::sum);
        for (Entry<String, Integer> entry : tree.entrySet()) {
            double percentage = entry.getValue()*100.0/total;
            System.out.printf("%s %.4f\n", entry.getKey(), percentage);
        }
    }
}
