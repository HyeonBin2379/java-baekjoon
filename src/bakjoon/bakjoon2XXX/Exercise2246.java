package bakjoon.bakjoon2XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise2246 {

    private static class Condo {
        int dist, cost;
        public Condo(int dist, int cost) {
            this.dist = dist;
            this.cost = cost;
        }
        public int getDist() {
            return dist;
        }

        public int getCost() {
            return cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Condo[] list = new Condo[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int distance = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[i] = new Condo(distance, cost);
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int canBeAnswer = 1;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (list[i].getDist() >= list[j].getDist()
                        && list[i].getCost() >= list[j].getCost()) {
                    canBeAnswer = 0;
                    break;
                }
            }
            answer += canBeAnswer;
        }
        System.out.println(answer);
    }
}
