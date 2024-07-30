package bakjoon.bakjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Exercise4483 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());
        for (int i = 1; i <= testcase; i++) {
            Map<String, Boolean> names = new LinkedHashMap<>();
            int n = Integer.parseInt(br.readLine());
            while (n-- > 0) {
                String name = br.readLine();
                names.put(name, false);
            }

            int m = Integer.parseInt(br.readLine());
            while (m-- > 0) {
                Arrays.stream(br.readLine().split(" "))
                        .filter(names::containsKey)
                        .forEach(name -> names.replace(name, true));
            }
            sb.append(String.format("Test set %d:\n", i));
            names.entrySet().stream()
                    .map(name -> {
                        if (name.getValue()) {
                            return String.format("%s is present\n", name.getKey());
                        } else {
                            return String.format("%s is absent\n", name.getKey());
                        }
                    })
                    .forEach(sb::append);
            sb.append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
