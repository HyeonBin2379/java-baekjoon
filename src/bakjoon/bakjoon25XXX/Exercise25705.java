package bakjoon.bakjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Exercise25705 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split("");
        int m = Integer.parseInt(br.readLine());
        String[] result = br.readLine().split("");

        if (!canMake(input, result)) {
            System.out.println(-1);
            return;
        }
        int now = n-1, index = 0;
        do {
            if (input[++now % n].equals(result[index])) {
                index++;
            }
        } while (index != m);
        System.out.println(now - (n-1));
    }

    private static boolean canMake(String[] input, String[] result) {
        Set<String> set1 = Arrays.stream(input).collect(Collectors.toSet());
        Set<String> set2 = Arrays.stream(result).collect(Collectors.toSet());
        return set1.containsAll(set2);
    }
}
