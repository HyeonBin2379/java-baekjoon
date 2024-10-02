package baekjoon.baekjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Exercise10546 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> runner = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            runner.put(name, runner.getOrDefault(name, 0)+1);
        }
        for (int i = 0; i < n-1; i++) {
            String name = br.readLine();
            runner.put(name, runner.get(name)-1);
        }
        runner.keySet().stream()
                .filter(s -> runner.get(s) == 1)
                .forEach(System.out::println);
    }
}
