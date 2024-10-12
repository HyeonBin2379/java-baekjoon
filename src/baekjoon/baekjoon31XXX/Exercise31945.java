package baekjoon.baekjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise31945 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testcase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] pos = new String[4];
            for (int j = 0; j < 4; j++) {
                String bin = Integer.toBinaryString(Integer.parseInt(st.nextToken()));
                pos[j] = String.format("%03d", Integer.parseInt(bin));
            }
            System.out.println(isSameSide(pos) ? "YES" : "NO");
        }
    }

    private static boolean isSameSide(String[] pos) {
        return IntStream.range(0, 3)
                .anyMatch(i -> IntStream.rangeClosed(0, 3).allMatch(j -> pos[j].charAt(i) == pos[0].charAt(i)));
    }
}
