package baekjoon.baekjoon28XXX;

import java.io.*;
import java.util.*;

public class Exercise28061 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] lemon = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, lemon[i]-(n-i));
        }
        System.out.println(max);
    }
}
