package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MostGiftsSolution {

    public int solution(String[] friends, String[] gifts) {
        int[][] giveAndTake = new int[friends.length][friends.length];
        Integer[] giftScore = new Integer[friends.length];
        List<String> index = new ArrayList<>(Arrays.asList(friends));
        Arrays.fill(giftScore, 0);
        for (String gift : gifts) {
            String[] tokens = gift.split(" ");
            int give = index.indexOf(tokens[0]);
            int take = index.indexOf(tokens[1]);
            giveAndTake[give][take]++;
            giftScore[give]--;
            giftScore[take]++;
        }

        int[] answer = new int[friends.length];
        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                if (i == j) {
                    continue;
                }

                if (giveAndTake[i][j] > giveAndTake[j][i]
                        || (giveAndTake[i][j] == giveAndTake[j][i] && giftScore[i] < giftScore[j])) {
                    answer[i]++;
                }
            }
        }
        Arrays.sort(answer);
        return answer[friends.length-1];
    }
}
public class MostGifts {
    public static void main(String[] args) {
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        MostGiftsSolution result = new MostGiftsSolution();
        System.out.println(result.solution(friends, gifts));
    }
}
