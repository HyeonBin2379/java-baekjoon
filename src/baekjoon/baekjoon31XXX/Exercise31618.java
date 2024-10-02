package baekjoon.baekjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Exercise31618 {
    private static Set<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        set = Arrays.stream(br.readLine().split(" ", len)).map(Integer::parseInt).collect(Collectors.toSet());
        System.out.println(isAnyMatched() ? "Yes" : "No");
    }

    public static boolean isAnyMatched() {
        return set.stream().anyMatch(integer -> set.contains(integer-3) && set.contains(integer+3));
    }
}
