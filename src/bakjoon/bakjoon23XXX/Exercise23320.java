package bakjoon.bakjoon23XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise23320 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] score = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .toArray(Integer[]::new);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int percent = Integer.parseInt(st.nextToken());
        int minLimit = Integer.parseInt(st.nextToken());

        int abs = (n*percent)/100;
        int rel = (int) IntStream.rangeClosed(0, n-1).takeWhile(i -> score[i] >= minLimit).count();
        System.out.println(abs + " " + rel);
    }
}
