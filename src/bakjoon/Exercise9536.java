package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Exercise9536 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            List<String> howling = Arrays.stream(br.readLine().split(" ")).toList();
            Set<String> notFox = new HashSet<>();
            while (true) {
                String input = br.readLine();
                if (input.equals("what does the fox say?")) {
                    break;
                }
                String[] token = input.split(" ");
                notFox.add(token[2]);
            }
            String result = howling.stream().filter(s -> !notFox.contains(s)).collect(Collectors.joining(" "));
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}
