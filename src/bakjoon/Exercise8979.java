package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise8979 {

    private static class Medals implements Comparable<Medals> {
        int country, gold, silver, bronze, rank;

        public Medals(int[] data) {
            this.country = data[0];
            this.gold = data[1];
            this.silver = data[2];
            this.bronze = data[3];
        }

        private void setRank(int rank) {
            this.rank = rank;
        }
        public boolean equals(Medals o) {
            return this.gold == o.gold
                    && this.silver == o.silver
                    && this.bronze == o.bronze;
        }

        @Override
        public int compareTo(Medals o) {
            if (this.gold != o.gold) {
                return o.gold-this.gold;
            } else if (this.silver != o.silver) {
                return o.silver-this.silver;
            } else {
                return o.bronze-this.bronze;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        List<Medals> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            result.add(new Medals(data));
        }
        Collections.sort(result);
        result.get(0).setRank(1);

        int index = 0;
        for (int i = 1; i < result.size(); i++) {
            if (result.get(i).country == target) {
                index = i;
            }
            if (result.get(i).equals(result.get(i-1))) {
                result.get(i).setRank(result.get(i-1).rank);
            } else {
                result.get(i).setRank(i+1);
            }
        }
        System.out.println(result.get(index).rank);
    }
}
