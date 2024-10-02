package baekjoon.baekjoon30XXX;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Exercise30957 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> BSA = new LinkedHashMap<>();
        int len = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split("");
        for (int i = 0; i < len; i++) {
            BSA.put(input[i], BSA.getOrDefault(input[i], 0)+1);
        }

        List<String> key = new ArrayList<>(BSA.keySet());
        key.sort((o1, o2) -> BSA.get(o2)-BSA.get(o1));
        String result = key.stream().filter(s -> Objects.equals(BSA.get(s), BSA.get(key.get(0)))).collect(Collectors.joining());
        if (result.length() != 2) {
            System.out.println(result.length() == 1 ? result : "SCU");
            return;
        }

        if (!result.contains("B")) {
            System.out.println("SA");
        } else {
            System.out.println((!result.contains("S")) ? "BA" : "BS");
        }
    }
}
