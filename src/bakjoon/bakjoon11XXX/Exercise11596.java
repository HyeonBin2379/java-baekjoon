package bakjoon.bakjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise11596 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] tri1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int[] tri2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        if (isRight(tri1) && isRight(tri2) && isSame(tri1, tri2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean isRight(int[] tri) {
        return tri[0]*tri[0]+tri[1]*tri[1] == tri[2]*tri[2];
    }

    private static boolean isSame(int[] tri1, int[] tri2) {
        return IntStream.rangeClosed(0, 2).allMatch(i -> tri1[i] == tri2[i]);
    }
}
