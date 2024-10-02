package bakjoon.bakjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Exercise14674 {

    private static class Game implements Comparable<Game> {
        int index, cost, happiness;

        public Game(int index, int cost, int happiness) {
            this.index = index;
            this.cost = cost;
            this.happiness = happiness;
        }

        @Override
        public int compareTo(Game o) {
            long c_eff1 = (long) o.cost *this.happiness;
            long c_eff2 = (long) this.cost *o.happiness;

            if (c_eff1 != c_eff2) {
                return Long.compare(c_eff2, c_eff1);
            } else if (this.cost != o.cost) {
                return Integer.compare(this.cost, o.cost);
            } else {
                return Integer.compare(this.index, o.index);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Game> smog = new PriorityQueue<>();
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int gameNum = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            int happiness = Integer.parseInt(st.nextToken());
            smog.add(new Game(gameNum, cost, happiness));
        }
        while (k-- > 0 && !smog.isEmpty()) {
            Game purchased = smog.poll();
            System.out.println(purchased.index);
        }
    }
}
