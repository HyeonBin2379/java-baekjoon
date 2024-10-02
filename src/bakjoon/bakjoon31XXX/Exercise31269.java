package bakjoon.bakjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exercise31269 {

    private static class Kod implements Comparable<Kod> {
        int label, score, vote;

        public Kod(int label, int score, int vote) {
            this.label = label;
            this.score = score;
            this.vote = vote;
        }

        @Override
        public int compareTo(Kod o) {
            return this.score != o.score ? Integer.compare(o.score, this.score) : Integer.compare(o.vote, this.vote);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] totalScore = new int[n];
        for (int i = 0; i < n; i++) {
            int label = Integer.parseInt(st.nextToken())-1;
            totalScore[label] = n-i;
        }
        int[] votes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, Integer> memberRank = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            memberRank.put(votes[i], i);
        }

        PriorityQueue<Kod> result = new PriorityQueue<>();
        int score = n;
        for (Entry<Integer, Integer> vote : memberRank.entrySet()) {
            int label = vote.getValue();
            totalScore[label] += score--;
            result.add(new Kod(label+1, totalScore[label], vote.getKey()));
        }

        int rank = 0;
        while (!result.isEmpty()) {
            Kod kod = result.poll();
            System.out.printf("%d. Kod%02d (%d)\n", ++rank, kod.label, kod.score);
        }
    }
}
