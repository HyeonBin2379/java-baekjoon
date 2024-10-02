package baekjoon.baekjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exercise28074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> mobis = new HashSet<>(List.of("M", "O", "B", "I", "S"));
        String str = br.readLine();
        Set<String> inputSet = new HashSet<>(Arrays.asList(str.split("")));
        br.close();
        System.out.println(inputSet.containsAll(mobis) ? "YES" : "NO");
    }
}
