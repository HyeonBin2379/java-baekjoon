package baekjoon.baekjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise15953 {

    private enum ContestA {
        FIRST(5000000, 1, 1),
        SECOND(3000000, 2, 3),
        THIRD(2000000, 4, 6),
        FOURTH(500000, 7, 10),
        FIFTH(300000, 11, 15),
        SIXTH(100000, 16, 21),
        NONE(0, 0, 0);

        private final int reward, maxRank, minRank;

        ContestA(int reward, int maxRank, int minRank) {
            this.reward = reward;
            this.maxRank = maxRank;
            this.minRank = minRank;
        }

        public static int getReward(int rank) {
            return Arrays.stream(ContestA.values())
                    .filter(contestA -> contestA.maxRank <= rank && rank <= contestA.minRank)
                    .findAny()
                    .orElse(NONE)
                    .reward;
        }
    }
    private enum ContestB {
        FIRST(5120000, 1, 1),
        SECOND(2560000, 2, 3),
        THIRD(1280000, 4, 7),
        FOURTH(640000, 8, 15),
        FIFTH(320000, 16, 31),
        NONE(0, 0, 0);

        private final int reward, maxRank, minRank;

        ContestB(int reward, int maxRank, int minRank) {
            this.reward = reward;
            this.maxRank = maxRank;
            this.minRank = minRank;
        }

        public static int getReward(int rank) {
            return Arrays.stream(ContestB.values())
                    .filter(contestB -> contestB.maxRank <= rank && rank <= contestB.minRank)
                    .findAny()
                    .orElse(NONE)
                    .reward;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(ContestA.getReward(a) + ContestB.getReward(b)).append("\n");
        }
        System.out.print(sb);
    }
}
