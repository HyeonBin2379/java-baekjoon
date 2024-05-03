package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Exercise8965 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            Set<String> seq = new TreeSet<>();
            String circle = br.readLine();
            int len = circle.length();
            for (int j = 0; j < len; j++) {
                seq.add(circle.substring(j) + circle.substring(0, j));
            }
            System.out.println(seq.stream()
                    .limit(1)
                    .toList()
                    .get(0));
        }
    }
}
