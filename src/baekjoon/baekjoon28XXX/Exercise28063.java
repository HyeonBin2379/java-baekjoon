package baekjoon.baekjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;

public class Exercise28063 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] start = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if (size < 3) {
            System.out.println(size == 1 ? 0 : 2);
            return;
        }

        Set<Integer> side = Set.of(1, size);
        if (side.contains(start[0]) && side.contains(start[1])) {
            System.out.println(2);
        } else if (side.contains(start[0]) || side.contains(start[1])) {
            System.out.println(3);
        } else {
            System.out.println(4);
        }
    }
}
