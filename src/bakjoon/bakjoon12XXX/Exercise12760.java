package bakjoon.bakjoon12XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise12760 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer>[] cards = new PriorityQueue[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cards[i] = new PriorityQueue<>(Comparator.reverseOrder());
            for (int j = 0; j < m; j++) {
                cards[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        int[] score = new int[n];
        for (int i = 0; i < m; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                max = Math.max(cards[j].peek(), max);
            }

            for (int j = 0; j < n; j++) {
                if (cards[j].poll() == max) {
                    score[j]++;
                }
            }
        }
        int max = Arrays.stream(score).max().getAsInt();
        IntStream.rangeClosed(1, n)
                .filter(index -> score[index-1] == max)
                .forEach(index -> System.out.print(index + " "));
    }
}
